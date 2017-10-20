/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.deservel.taotao.service.impl;

import com.deservel.taotao.model.vo.PicUploadResultVO;
import com.deservel.taotao.service.PicUploadService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 图片上传服务类
 *
 * @author DeserveL
 * @date 2017/10/19 0019 下午 21:06
 * @since 1.0.0
 */
@Service
public class PicUploadServiceImpl implements PicUploadService {

    private static final Logger log = LoggerFactory.getLogger(PicUploadServiceImpl.class);

    /**
     * 图片后缀分隔符
     */
    @Value("${image.separator}")
    private String imageSeparator;
    /**
     * 图片后缀
     */
    @Value("${image.type}")
    private String imageType;
    /**
     * 图片服务器
     */
    @Value("${image.server}")
    private String imageServer;
    /**
     * 图片存放路径
     */
    @Value("${image.location}")
    private String imageLocation;

    /**
     * 图片上传
     *
     * @param uploadFile
     * @return
     */
    @Override
    public PicUploadResultVO upload(MultipartFile uploadFile) {
        PicUploadResultVO picUploadResultVO = new PicUploadResultVO();
        picUploadResultVO.setError(1);

        //检查图片后缀是否合法
        if (!checkPictureSuffix(uploadFile.getOriginalFilename())) {
            return picUploadResultVO;
        }

        //文件相对路径
        String filePath = getFilePath(uploadFile.getOriginalFilename());
        //文件新路径
        String allFilePath = imageLocation + filePath;
        //日志打印
        if (log.isDebugEnabled()) {
            log.debug("Pic file upload .[{}] to [{}] .", uploadFile.getOriginalFilename(), allFilePath);
        }
        // 写文件到磁盘
        File newFile = new File(allFilePath);
        try {
            uploadFile.transferTo(newFile);
        } catch (IOException e) {
            log.error("图片写入失败"+e.getMessage());
            return picUploadResultVO;
        }
        //获取文件长和宽
        boolean isLegal = false;
        try {
            BufferedImage image = ImageIO.read(newFile);
            if (image != null) {
                //图片合法
                isLegal = true;
                picUploadResultVO.setWidth(image.getWidth() + "");
                picUploadResultVO.setHeight(image.getHeight() + "");
            }
        } catch (IOException e) {
            log.error("图片解析失败"+e.getMessage());
        }
        //不合法
        if(!isLegal){
            newFile.delete();
            return picUploadResultVO;
        }

        // 生成图片的绝对引用地址
        String picUrl = StringUtils.replace(filePath,"\\", "/");
        picUploadResultVO.setUrl(imageServer + picUrl);
        picUploadResultVO.setError(0);

        return picUploadResultVO;
    }

    /**
     * 检验图片后缀
     *
     * @param imageName
     * @return
     */
    public boolean checkPictureSuffix(String imageName) {
        if (null != imageName & null != imageType) {
            String[] type = imageType.split(imageSeparator);
            for (String s : type) {
                if (StringUtils.endsWithIgnoreCase(imageName, s)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 文件保存路径（相对）  （/image/2017/01/01）
     *
     * @param sourceFileName
     * @return
     */
    private String getFilePath(String sourceFileName) {
        // /image
        String baseFolder = File.separator + "images";
        Date nowDate = new Date();
        // yyyy/MM/dd
        String fileFolder = baseFolder + File.separator + new DateTime(nowDate).toString("yyyy")
                + File.separator + new DateTime(nowDate).toString("MM") + File.separator
                + new DateTime(nowDate).toString("dd");
        File file = new File(imageLocation + fileFolder);
        if (!file.isDirectory()) {
            // 如果目录不存在，则创建目录
            file.mkdirs();
        }
        // 生成新的文件名
        String fileName = new DateTime(nowDate).toString("yyyyMMddhhmmssSSSS")
                + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
        return fileFolder + File.separator + fileName;
    }

}
