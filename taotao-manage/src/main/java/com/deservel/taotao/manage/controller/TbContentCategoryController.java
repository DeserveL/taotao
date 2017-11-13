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

import com.deservel.taotao.model.po.TbContentCategory;
import com.deservel.taotao.model.vo.TbContentCategoryVO;
import com.deservel.taotao.service.TbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author DeserveL
 * @date 2017/11/10 9:27
 * @since 1.0.0
 */
@Controller
@RequestMapping("content/category")
public class TbContentCategoryController {

    @Autowired
    TbContentCategoryService tbContentCategoryService;

    /**
     * 查询分类内容树
     *
     * @param parentId
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TbContentCategoryVO>> queryContentCategoryList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<TbContentCategoryVO> tbContentCategoryVOs = tbContentCategoryService.queryContentCategoryList(parentId);
        return ResponseEntity.ok(tbContentCategoryVOs);
    }

    /**
     * 保存树节点
     *
     * @param tbContentCategory
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TbContentCategory> saveContentCategoryList(TbContentCategory tbContentCategory) {
        TbContentCategory tbContentCategoryRs = tbContentCategoryService.saveContentCategoryList(tbContentCategory);
        return ResponseEntity.ok(tbContentCategoryRs);
    }

    /**
     * 修改节点名字
     *
     * @param tbContentCategory
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateName(TbContentCategory tbContentCategory) {
        if(tbContentCategoryService.updateName(tbContentCategory)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 删除节点
     *
     * @param tbContentCategory
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteNode(TbContentCategory tbContentCategory) {
        if(tbContentCategoryService.deleteNode(tbContentCategory)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
