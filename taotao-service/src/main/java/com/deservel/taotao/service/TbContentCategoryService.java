package com.deservel.taotao.service;

import com.deservel.taotao.model.po.TbContentCategory;
import com.deservel.taotao.model.vo.TbContentCategoryVO;

import java.util.List;

/**
 * @author DeserveL
 * @date 2017/11/10 9:29
 * @since 1.0.0
 */
public interface TbContentCategoryService extends BaseService<TbContentCategory>{

    /**
     *  查询分类列表
     *
     * @param parentId
     * @return
     */
    List<TbContentCategoryVO> queryContentCategoryList(Long parentId);

    /**
     * 保存树节点
     *
     * @param tbContentCategory
     * @return
     */
    TbContentCategory saveContentCategoryList(TbContentCategory tbContentCategory);

    /**
     * 修改节点名字
     *
     * @param tbContentCategory
     * @return
     */
    boolean updateName(TbContentCategory tbContentCategory);

    /**
     * 删除节点
     *
     * @param tbContentCategory
     * @return
     */
    boolean deleteNode(TbContentCategory tbContentCategory);
}
