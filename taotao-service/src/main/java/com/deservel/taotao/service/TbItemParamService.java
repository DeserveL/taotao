package com.deservel.taotao.service;

import com.deservel.taotao.common.model.EasyUIGridResultVO;
import com.deservel.taotao.model.po.TbItemParam;

/**
 * @author DeserveL
 * @date 2017/10/30 0030 下午 22:03
 * @since 1.0.0
 */
public interface TbItemParamService extends BaseService<TbItemParam>{

    /**
     * 根据分类信息查找模版信息
     *
     * @param itemCatId
     * @return
     */
    TbItemParam queryItemParamByItemCatId(Long itemCatId);

    /**
     * 新增规格参数模版信息
     *
     * @param itemCatId
     * @param paramData
     * @return
     */
    Boolean saveItemParam(Long itemCatId, String paramData);

    /**
     * 根据所有规格参数模版信息
     *
     * @param page
     * @param rows
     * @return
     */
    EasyUIGridResultVO queryItemParam(Integer page, Integer rows);
}
