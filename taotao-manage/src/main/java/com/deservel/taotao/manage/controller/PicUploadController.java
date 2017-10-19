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
package com.deservel.taotao.manage.controller;

import com.deservel.taotao.model.vo.PicUploadResultVO;
import com.deservel.taotao.service.PicUploadService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传
 *
 * @author DeserveL
 * @date 2017/10/19 0019 下午 20:59
 * @since 1.0.0
 */
@Controller
@RequestMapping("pic")
public class PicUploadController {

    @Autowired
    PicUploadService picUploadService;

    /**
     * 图片上传 返回纯文本类型
     *
     * @param uploadFile
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "upload", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String upload(@RequestParam("uploadFile") MultipartFile uploadFile) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(picUploadService.upload(uploadFile));
    }
}
