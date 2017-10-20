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

import com.deservel.taotao.model.po.TbItemCat;
import com.deservel.taotao.model.vo.TbItemCatVO;
import com.deservel.taotao.service.TbItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类
 *
 * @author DeserveL
 * @date 2017/10/16 16:30
 * @since 1.0.0
 */
@Controller
@RequestMapping("item/cat")
public class TbItemCatController {

    @Autowired
    TbItemCatService tbItemCatService;

    /**
     * 获取分类list
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public List<TbItemCatVO> queryItemCat(@RequestParam(value = "id", defaultValue = "0") Long id) {
        List<TbItemCatVO> tbItemCatVOs = tbItemCatService.queryItemCat(id);
        return tbItemCatVOs;
    }

    /**
     * 获取单个分类详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public TbItemCat queryItemCatById(@PathVariable Long id) {
        TbItemCat tbItemCat = tbItemCatService.queryItemCatById(id);
        return tbItemCat;
    }
}
