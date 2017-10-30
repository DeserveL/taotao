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
import com.deservel.taotao.model.po.TbItem;
import com.deservel.taotao.model.po.TbItemDesc;
import com.deservel.taotao.model.po.TbItemParamItem;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbItemDescService;
import com.deservel.taotao.service.TbItemParamItemService;
import com.deservel.taotao.service.TbItemService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * 商品
 *
 * @author DeserveL
 * @date 2017/10/18 16:56
 * @since 1.0.0
 */
@Service
public class TbItemServiceImpl extends AbstractBaseService<TbItem> implements TbItemService {

    @Autowired
    TbItemDescService tbItemDescService;

    @Autowired
    TbItemParamItemService tbItemParamItemService;

    /***
     * 保存商品描述(支持事务)
     *
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    @Override
    public Boolean saveItem(TbItem tbItem, String desc, String itemParams) {
        tbItem.setId(null);
        tbItem.setStatus((byte) 1);
        tbItem.setUpdated(null);
        tbItem.setCreated(null);
        Integer save = this.save(tbItem);
        if (save > 0) {
            //商品分类
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(tbItem.getId());
            tbItemDesc.setItemDesc(desc);
            Integer saveDesc = tbItemDescService.save(tbItemDesc);

            //商品规格
            TbItemParamItem tbItemParamItem = new TbItemParamItem();
            tbItemParamItem.setItemId(tbItem.getId());
            tbItemParamItem.setParamData(itemParams);
            Integer saveParam = tbItemParamItemService.save(tbItemParamItem);

            if (saveDesc > 0 && saveParam > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 更新商品
     *
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    @Override
    public Boolean updateItem(TbItem tbItem, String desc, String itemParams) {
        tbItem.setStatus(null);
        tbItem.setUpdated(null);
        tbItem.setCreated(null);
        Integer update = this.updateByPrimaryKeySelective(tbItem);
        if (update > 0) {
            //更新分类信息
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(tbItem.getId());
            tbItemDesc.setItemDesc(desc);
            Integer updateDesc = tbItemDescService.updateByPrimaryKeySelective(tbItemDesc);

            //更新商品规格
            TbItemParamItem tbItemParamItem = new TbItemParamItem();
            tbItemParamItem.setParamData(itemParams);
            Example example = new Example(TbItemParamItem.class);
            example.createCriteria().andEqualTo("itemId", tbItem.getId());
            Integer updateParamItem = tbItemParamItemService.updateByExampleSelective(tbItemParamItem, example);
            if (updateDesc > 0 && updateParamItem > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询商品
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EasyUIGridResultVO queryItemList(Integer page, Integer rows) {
        Example example = new Example(TbItem.class);
        example.setOrderByClause("updated DESC");
        PageInfo<TbItem> tbItemPageInfo = this.queryPageListByExample(page, rows, example);
        return new EasyUIGridResultVO(tbItemPageInfo.getTotal(), tbItemPageInfo.getList());
    }

    /**
     * 查询商品描述
     *
     * @param id
     * @return
     */
    @Override
    public TbItemDesc queryItemDesc(Long id) {
        return tbItemDescService.queryById(id);
    }
}
