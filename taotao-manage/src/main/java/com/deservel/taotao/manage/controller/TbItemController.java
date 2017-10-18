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

import com.deservel.taotao.model.po.TbItem;
import com.deservel.taotao.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DeserveL
 * @date 2017/10/18 16:48
 * @since 1.0.0
 */
@Controller
@RequestMapping("item")
public class TbItemController {

    @Autowired
    TbItemService tbItemService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveItem(TbItem tbItem, String desc) {
        if (StringUtils.isEmpty(tbItem.getTitle())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Boolean flag = tbItemService.saveItem(tbItem, desc);
        if (flag) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
