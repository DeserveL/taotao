package com.deservel.taotao.dao;

import com.deservel.taotao.model.po.TbContent;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author deservel
 */
public interface TbContentMapper extends Mapper<TbContent> {
    /**
     * 获取内容列表
     *
     * @param categoryId
     * @return
     */
    List<TbContent> queryListByCategoryId(Long categoryId);
}