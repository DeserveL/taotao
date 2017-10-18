package com.deservel.taotao.service;

import com.deservel.taotao.model.po.TbItem;

/**
 * 商品类
 *
 * @author DeserveL
 * @date 2017/10/18 16:54
 * @since 1.0.0
 */
public interface TbItemService extends BaseService<TbItem>{

    /**
     * 保存商品
     *
     * @param tbItem
     * @param desc
     * @return
     */
    Boolean saveItem(TbItem tbItem, String desc);
}
