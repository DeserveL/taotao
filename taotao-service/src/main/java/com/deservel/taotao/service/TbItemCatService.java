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
package com.deservel.taotao.service;

import com.deservel.taotao.model.po.TbItemCat;
import com.deservel.taotao.model.vo.ItemCatResultVO;
import com.deservel.taotao.model.vo.TbItemCatVO;

import java.util.List;

/**
 * 商品分类
 *
 * @author DeserveL
 * @date 2017/10/16 16:35
 * @since 1.0.0
 */
public interface TbItemCatService extends BaseService<TbItemCat>{

    /**
     * 查询商品分类list
     *
     * @param parentId
     * @return
     */
    List<TbItemCatVO> queryItemCat(Long parentId);

    /**
     * 单个分类详情
     *
     * @param id
     * @return
     */
    TbItemCat queryItemCatById(Long id);

    /**
     * 商品分类tree
     *
     * @return
     */
    ItemCatResultVO queryItemCatTree();
}
