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

import com.deservel.taotao.model.po.TbItem;
import com.deservel.taotao.model.po.TbItemDesc;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbItemDescService;
import com.deservel.taotao.service.TbItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /***
     * 保存商品描述(支持事务)
     *
     * @param tbItem
     * @param desc
     * @return
     */
    @Override
    public Boolean saveItem(TbItem tbItem, String desc){
        tbItem.setId(null);
        tbItem.setStatus((byte) 1);
        tbItem.setUpdated(null);
        tbItem.setCreated(null);
        Integer save = this.save(tbItem);
        if (save > 0) {
            TbItemDesc tbItemDesc = new TbItemDesc();
            tbItemDesc.setItemId(tbItem.getId());
            tbItemDesc.setItemDesc(desc);
            Integer saveDesc = tbItemDescService.save(tbItemDesc);
            if (saveDesc > 0) {
                return true;
            }
        }
        return false;
    }
}
