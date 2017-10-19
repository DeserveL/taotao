package com.deservel.taotao.service;

import com.deservel.taotao.model.vo.PicUploadResultVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传服务类
 *
 * @author DeserveL
 * @date 2017/10/19 0019 下午 21:02
 * @since 1.0.0
 */
public interface PicUploadService {

    /**
     * 图片上传
     *
     * @param uploadFile
     * @return
     */
    PicUploadResultVO upload(MultipartFile uploadFile);
}
