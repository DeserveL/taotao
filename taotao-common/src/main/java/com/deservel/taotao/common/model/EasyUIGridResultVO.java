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
package com.deservel.taotao.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * easyui表格grid
 *
 * @author DeserveL
 * @date 2017/10/20 14:13
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class EasyUIGridResultVO {

    private Long total;

    private List<?> rows;
}