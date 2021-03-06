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
package com.deservel.taotao.model.vo;

import lombok.Data;

/**
 * 图片上传
 *
 * @author DeserveL
 * @date 2017/10/19 0019 下午 20:56
 * @since 1.0.0
 */
@Data
public class PicUploadResultVO {
    private Integer error;

    private String url;

    private String width;

    private String height;
}
