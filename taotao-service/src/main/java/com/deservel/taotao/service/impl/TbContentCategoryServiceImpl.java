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

    /**
     * 保存树节点
     *
     * @param tbContentCategory
     * @return
     */
    @Override
    public TbContentCategory saveContentCategoryList(TbContentCategory tbContentCategory) {
        tbContentCategory.setId(null);
        tbContentCategory.setIsParent(false);
        tbContentCategory.setSortOrder(1);
        tbContentCategory.setStatus(1);
        super.save(tbContentCategory);

        //查询父节点是否有子节点 没有 则改状态
        TbContentCategory tbContentCategoryParent = super.queryById(tbContentCategory.getParentId());
        if (!tbContentCategoryParent.getIsParent()) {
            tbContentCategoryParent.setIsParent(true);
            super.updateByPrimaryKeySelective(tbContentCategoryParent);
        }

        return tbContentCategory;
    }

    /**
     * 修改节点名字
     *
     * @param tbContentCategory
     * @return
     */
    @Override
    public boolean updateName(TbContentCategory tbContentCategory) {
        Integer integer = super.updateByPrimaryKeySelective(tbContentCategory);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除子节点全部
     *
     * @param tbContentCategory
     * @return
     */
    @Override
    public boolean deleteNode(TbContentCategory tbContentCategory) {
        ArrayList<Object> ids = new ArrayList<>();
        ids.add(tbContentCategory.getId());

        // 递归查找该节点下的所有子节点id
        this.findAllSubNode(ids, tbContentCategory.getId());

        // 删除所有节点
        super.deleteByIds("id", ids);

        // 判断该节点是否还有兄弟节点，如果没有，修改父节点的isParent为false
        TbContentCategory record = new TbContentCategory();
        record.setParentId(tbContentCategory.getParentId());
        List<TbContentCategory> list = super.queryListByWhere(record);
        if (null == list || list.isEmpty()) {
            TbContentCategory parent = new TbContentCategory();
            parent.setId(tbContentCategory.getParentId());
            parent.setIsParent(false);
            super.updateByPrimaryKeySelective(parent);
        }

        return true;
    }

    /**
     * 查找该节点下的所有子节点
     *
     * @param ids
     * @param pid
     */
    private void findAllSubNode(List<Object> ids, Long pid) {
        TbContentCategory record = new TbContentCategory();
        record.setParentId(pid);
        List<TbContentCategory> list = super.queryListByWhere(record);
        for (TbContentCategory contentCategory : list) {
            ids.add(contentCategory.getId());
            // 判断该节点是否为父节点，如果是，继续调用该方法查找子节点
            if (contentCategory.getIsParent()) {
                // 开始递归
                findAllSubNode(ids, contentCategory.getId());
            }
        }
    }

}
