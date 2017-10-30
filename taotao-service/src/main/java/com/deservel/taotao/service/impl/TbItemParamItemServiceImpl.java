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

import com.deservel.taotao.model.po.TbItemParamItem;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbItemParamItemService;
import org.springframework.stereotype.Service;

/**
 * 商品的规格参数
 *
 * @author DeserveL
 * @date 2017/10/30 0030 下午 22:07
 * @since 1.0.0
 */
@Service
public class TbItemParamItemServiceImpl extends AbstractBaseService<TbItemParamItem> implements TbItemParamItemService {

    /**
     * 查找商品的规格参数信息
     *
     * @param itemId
     * @return
     */
    @Override
    public TbItemParamItem queryByItemId(Long itemId) {
        TbItemParamItem tbItemParamItem = new TbItemParamItem();
        tbItemParamItem.setItemId(itemId);
        return this.queryOne(tbItemParamItem);
    }
}
