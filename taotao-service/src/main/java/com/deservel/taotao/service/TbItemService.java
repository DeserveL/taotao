package com.deservel.taotao.service;

import com.deservel.taotao.common.model.EasyUIGridResultVO;
import com.deservel.taotao.model.po.TbItem;
import com.deservel.taotao.model.po.TbItemDesc;

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
     * @param itemParams
     * @return
     */
    Boolean saveItem(TbItem tbItem, String desc, String itemParams);

    /**
     * 更新商品
     *
     * @param tbItem
     * @param desc
     * @param itemParams
     * @return
     */
    Boolean updateItem(TbItem tbItem, String desc, String itemParams);

    /**
     * 查询商品
     *
     * @param page
     * @param rows
     * @return
     */
    EasyUIGridResultVO queryItemList(Integer page, Integer rows);

    /**
     * 查询商品描述
     *
     * @param id
     * @return
     */
    TbItemDesc queryItemDesc(Long id);
}
