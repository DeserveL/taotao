package com.deservel.taotao.service;

import com.deservel.taotao.common.model.EasyUIGridResultVO;
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

    /**
     * 查询商品
     *
     * @param page
     * @param rows
     * @return
     */
    EasyUIGridResultVO queryItemList(Integer page, Integer rows);
}
