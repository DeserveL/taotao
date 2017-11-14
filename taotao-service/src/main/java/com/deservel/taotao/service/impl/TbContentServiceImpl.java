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

import com.deservel.taotao.common.model.EasyUIGridResultVO;
import com.deservel.taotao.dao.TbContentMapper;
import com.deservel.taotao.model.po.TbContent;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DeserveL
 * @date 2017/11/10 9:32
 * @since 1.0.0
 */
@Service
public class TbContentServiceImpl extends AbstractBaseService<TbContent> implements TbContentService {

    @Autowired
    TbContentMapper tbContentMapper;

    /**
     * 获取内容列表
     *
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIGridResultVO queryListByCategoryId(Long categoryId, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<TbContent> tbContentList = tbContentMapper.queryListByCategoryId(categoryId);
        PageInfo<TbContent> tbContentPageInfo = new PageInfo<>(tbContentList);
        return new EasyUIGridResultVO(tbContentPageInfo.getTotal(), tbContentPageInfo.getList());
    }

    /**
     * 保存内容信息
     *
     * @param tbContent
     * @return
     */
    @Override
    public boolean saveContent(TbContent tbContent) {
        Integer save = super.save(tbContent);
        if (save > 0) {
            return true;
        }
        return false;
    }

    /**
     * 更新
     *
     * @param tbContent
     * @return
     */
    @Override
    public boolean updateContent(TbContent tbContent) {
        Integer update = super.updateByPrimaryKeySelective(tbContent);
        if (update > 0) {
            return true;
        }
        return false;
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @Override
    public boolean deleteContent(String ids) {
        if (ids != null) {
            String[] id = ids.split(",");
            for (String s : id) {
                super.deleteById(Long.valueOf(s));
            }
            return true;
        }
        return false;
    }
}
