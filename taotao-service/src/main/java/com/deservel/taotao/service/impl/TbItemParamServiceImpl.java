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
import com.deservel.taotao.model.po.TbItemParam;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbItemParamService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 规格参数模版表
 *
 * @author DeserveL
 * @date 2017/10/30 0030 下午 22:04
 * @since 1.0.0
 */
@Service
public class TbItemParamServiceImpl extends AbstractBaseService<TbItemParam> implements TbItemParamService {

    /**
     * 根据分类信息查找模版信息
     *
     * @param itemCatId
     * @return
     */
    @Override
    public TbItemParam queryItemParamByItemCatId(Long itemCatId) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(itemCatId);
        TbItemParam rs = this.queryOne(tbItemParam);
        return rs;
    }

    /**
     * 新增模版信息
     *
     * @param itemCatId
     * @param paramData
     * @return
     */
    @Override
    public Boolean saveItemParam(Long itemCatId, String paramData) {
        TbItemParam tbItemParam = new TbItemParam();
        tbItemParam.setItemCatId(itemCatId);
        tbItemParam.setParamData(paramData);
        Integer save = this.save(tbItemParam);
        return save > 0 ? true : false;
    }

    /**
     * 查询所有规格参数模版信息
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIGridResultVO queryItemParam(Integer page, Integer rows) {
        Example example = new Example(TbItemParam.class);
        example.setOrderByClause("updated DESC");

        PageInfo<TbItemParam> tbItemParamPageInfo = this.queryPageListByExample(page, rows, example);

        return new EasyUIGridResultVO(tbItemParamPageInfo.getTotal(), tbItemParamPageInfo.getList());
    }
}
