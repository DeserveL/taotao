package com.deservel.taotao.dao;

import com.deservel.taotao.model.po.TbItemCat;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TbItemCatMapper {
    /**
     *
     * @mbggenerated
     */
    @Delete({
        "delete from tb_item_cat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    @Insert({
        "insert into tb_item_cat (id, parent_id, ",
        "name, status, sort_order, ",
        "is_parent, created, ",
        "updated)",
        "values (#{id,jdbcType=BIGINT}, #{parentId,jdbcType=BIGINT}, ",
        "#{name,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, #{sortOrder,jdbcType=INTEGER}, ",
        "#{isParent,jdbcType=BIT}, #{created,jdbcType=TIMESTAMP}, ",
        "#{updated,jdbcType=TIMESTAMP})"
    })
    int insert(TbItemCat record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(TbItemCat record);

    /**
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, parent_id, name, status, sort_order, is_parent, created, updated",
        "from tb_item_cat",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("BaseResultMap")
    TbItemCat selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(TbItemCat record);

    /**
     *
     * @mbggenerated
     */
    @Update({
        "update tb_item_cat",
        "set parent_id = #{parentId,jdbcType=BIGINT},",
          "name = #{name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "sort_order = #{sortOrder,jdbcType=INTEGER},",
          "is_parent = #{isParent,jdbcType=BIT},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "updated = #{updated,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TbItemCat record);
}