package com.deservel.taotao.service;

import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 *
 * @author DeserveL
 * @date 2017/10/17 0017 下午 21:41
 * @since 1.0.0
 */
public interface BaseService<T> {
    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    T queryById(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
    ;

    List<T> queryAll();

    /**
     * 根据条件查询一条数据，如果有多条数据会抛出异常
     *
     * @param record
     * @return
     */
    T queryOne(T record);

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
    List<T> queryListByWhere(T record);

    /**
     * 根据条件分页查询
     *
     * @param page
     * @param rows
     * @param record
     * @return
     */
    PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record);

    /**
     * 根据example条件查询数据列表
     *
     * @param example
     * @return
     */
    List<T> queryListByExample(Example example);

    /**
     * 根据example条件分页查询
     *
     * @param page
     * @param rows
     * @param example
     * @return
     */
    PageInfo<T> queryPageListByExample(Integer page, Integer rows, Example example);

    /**
     * 新增数据，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer save(T record);

    /**
     * 新增数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer saveSelective(T record);

    /**
     * 修改数据，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer update(T record);

    /**
     * 修改数据，使用不为null的字段，返回成功的条数
     *
     * @param record
     * @return
     */
    Integer updateSelective(T record);

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * 批量删除
     *
     * @param property
     * @param values
     * @return
     */
    Integer deleteByIds(String property, List<Object> values);

    /**
     * 根据条件做删除
     *
     * @param record
     * @return
     */
    Integer deleteByWhere(T record);
}
