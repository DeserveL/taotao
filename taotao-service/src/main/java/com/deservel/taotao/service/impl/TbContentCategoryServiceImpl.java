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

import com.deservel.taotao.model.po.TbContentCategory;
import com.deservel.taotao.model.vo.TbContentCategoryVO;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbContentCategoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DeserveL
 * @date 2017/11/10 9:33
 * @since 1.0.0
 */
@Service
public class TbContentCategoryServiceImpl extends AbstractBaseService<TbContentCategory> implements TbContentCategoryService {

    /**
     * 查询分类列表
     *
     * @param parentId
     * @return
     */
    @Override
    public List<TbContentCategoryVO> queryContentCategoryList(Long parentId) {
        TbContentCategory tbContentCategory = new TbContentCategory();
        tbContentCategory.setParentId(parentId);
        List<TbContentCategory> tbContentCategoryList = super.queryListByWhere(tbContentCategory);

        ArrayList<TbContentCategoryVO> tbContentCategoryVOs = new ArrayList<>();
        if (null != tbContentCategoryList) {
            for (TbContentCategory select : tbContentCategoryList) {
                TbContentCategoryVO tbContentCategoryVO = new TbContentCategoryVO();
                tbContentCategoryVO.setId(select.getId());
                tbContentCategoryVO.setParentId(select.getParentId());
                tbContentCategoryVO.setText(select.getName());
                tbContentCategoryVO.setState(select.getIsParent() ? "closed" : "open");
                tbContentCategoryVOs.add(tbContentCategoryVO);
            }
        }
        return tbContentCategoryVOs;
    }
}
