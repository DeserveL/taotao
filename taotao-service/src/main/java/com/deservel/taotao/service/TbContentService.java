package com.deservel.taotao.service;

import com.deservel.taotao.common.model.EasyUIGridResultVO;
import com.deservel.taotao.model.po.TbContent;

/**
 * @author DeserveL
 * @date 2017/11/10 9:31
 * @since 1.0.0
 */
public interface TbContentService extends BaseService<TbContent>{

    /**
     * 获取内容列表
     *
     * @param categoryId
     * @param page
     * @param rows
     * @return
     */
    EasyUIGridResultVO queryListByCategoryId(Long categoryId, Integer page, Integer rows);

    /**
     * 保存内容信息
     *
     * @param tbContent
     * @return
     */
    boolean saveContent(TbContent tbContent);

    /**
     * 更新
     *
     * @param tbContent
     * @return
     */
    boolean updateContent(TbContent tbContent);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    boolean deleteContent(String ids);
}
