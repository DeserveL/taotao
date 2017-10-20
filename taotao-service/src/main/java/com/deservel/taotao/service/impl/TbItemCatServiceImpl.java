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
package com.deservel.taotao.service.impl;

import com.deservel.taotao.model.po.TbItemCat;
import com.deservel.taotao.model.vo.TbItemCatVO;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbItemCatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DeserveL
 * @date 2017/10/16 16:36
 * @since 1.0.0
 */
@Service
public class TbItemCatServiceImpl extends AbstractBaseService<TbItemCat> implements TbItemCatService{

    /**
     * 查询商品分类list
     *
     * @param parentId
     * @return
     */
    @Override
    public List<TbItemCatVO> queryItemCat(Long parentId) {
        //返回值
        List<TbItemCatVO> tbItemCatVOs = new ArrayList<>();

        TbItemCat tbItemCat = new TbItemCat();
        tbItemCat.setParentId(parentId);
        List<TbItemCat> select = this.queryListByWhere(tbItemCat);
        if (null != select) {
            for (TbItemCat itemCat : select) {
                TbItemCatVO tbItemCatVO = new TbItemCatVO();
                tbItemCatVO.setId(itemCat.getId());
                tbItemCatVO.setParentId(itemCat.getParentId());
                tbItemCatVO.setText(itemCat.getName());
                tbItemCatVO.setState(itemCat.getIsParent() ? "closed" : "open");
                tbItemCatVOs.add(tbItemCatVO);
            }
        }
        return tbItemCatVOs;
    }

    /**
     * 单个分类详情
     *
     * @param id
     * @return
     */
    @Override
    public TbItemCat queryItemCatById(Long id) {
        return this.queryById(id);
    }
}
