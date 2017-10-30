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

import com.deservel.taotao.common.model.EasyUIGridResultVO;
import com.deservel.taotao.model.po.TbItem;
import com.deservel.taotao.model.po.TbItemDesc;
import com.deservel.taotao.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 新增商品
     *
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveItem(TbItem tbItem, String desc, String itemParams) {
        if (StringUtils.isEmpty(tbItem.getTitle())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Boolean flag = tbItemService.saveItem(tbItem, desc, itemParams);
        if (flag) {
            //201
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 更新
     *
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateItem(TbItem tbItem, String desc, String itemParams) {
        if (StringUtils.isEmpty(tbItem.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Boolean flag = tbItemService.updateItem(tbItem, desc, itemParams);
        if (flag) {
            //204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询商品
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<EasyUIGridResultVO> queryItemList(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "30") Integer rows) {
        EasyUIGridResultVO easyUIGridResultVO = tbItemService.queryItemList(page, rows);
        return ResponseEntity.ok(easyUIGridResultVO);
    }

    /**
     * 获取商品描述
     *
     * @param id 商品ID
     * @return
     */
    @RequestMapping(value = "desc/{id}", method = RequestMethod.GET)
    public ResponseEntity<TbItemDesc> queryItemDesc(@PathVariable("id") Long id){
        TbItemDesc tbItemDesc = tbItemService.queryItemDesc(id);
        return ResponseEntity.ok(tbItemDesc);
    }
}
