package com.deservel.taotao.service;

import com.deservel.taotao.model.po.TbItemParamItem;

/**
 * 规格参数具体
 *
 * @author DeserveL
 * @date 2017/10/30 0030 下午 22:06
 * @since 1.0.0
 */
public interface TbItemParamItemService extends BaseService<TbItemParamItem> {

    /**
     * 查找商品的规格参数信息
     *
     * @param itemId
     * @return
     */
    TbItemParamItem queryByItemId(Long itemId);
}
