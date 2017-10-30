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
import com.deservel.taotao.model.po.TbItemParam;
import com.deservel.taotao.service.TbItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author DeserveL
 * @date 2017/10/30 0030 下午 22:11
 * @since 1.0.0
 */
@Controller
@RequestMapping("item/param")
public class TbItemParamController {

    @Autowired
    TbItemParamService tbItemParamService;

    /**
     * 查询所有规格参数模版信息
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<EasyUIGridResultVO> queryItemParam(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "rows", defaultValue = "30") Integer rows) {
        EasyUIGridResultVO easyUIGridResultVO = tbItemParamService.queryItemParam(page, rows);
        return ResponseEntity.ok(easyUIGridResultVO);
    }

    /**
     * 根据分类信息查找规格参数模版信息
     *
     * @param itemCatId
     * @return
     */
    @RequestMapping(value = "{itemCatId}", method = RequestMethod.GET)
    public ResponseEntity<TbItemParam> queryItemParamByItemCatId(@PathVariable("itemCatId") Long itemCatId) {
        TbItemParam tbItemParam = tbItemParamService.queryItemParamByItemCatId(itemCatId);
        if (tbItemParam == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            return ResponseEntity.ok(tbItemParam);
        }
    }

    /**
     * 新增规格参数模版
     *
     * @param itemCatId
     * @param paramData
     * @return
     */
    @RequestMapping(value = "{itemCatId}", method = RequestMethod.POST)
    public ResponseEntity<Void> saveItemParam(@PathVariable("itemCatId") Long itemCatId, String paramData) {
        Boolean flag = tbItemParamService.saveItemParam(itemCatId, paramData);
        if (flag) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
