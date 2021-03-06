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

import com.deservel.taotao.model.po.TbItemParamItem;
import com.deservel.taotao.service.TbItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author DeserveL
 * @date 2017/10/30 0030 下午 22:11
 * @since 1.0.0
 */
@Controller
@RequestMapping("item/param/item")
public class TbItemParamItemController {

    @Autowired
    TbItemParamItemService tbItemParamItemService;

    /**
     * 查找商品的规格参数信息
     *
     * @param itemId
     * @return
     */
    @RequestMapping(value = "{itemId}", method = RequestMethod.GET)
    public ResponseEntity<TbItemParamItem> queryByItemId(@PathVariable("itemId") Long itemId) {
        TbItemParamItem tbItemParamItem = tbItemParamItemService.queryByItemId(itemId);
        if (tbItemParamItem == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(tbItemParamItem);
        }
    }

}
