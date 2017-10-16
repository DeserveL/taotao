package com.deservel.taotao.model.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "tb_item_cat")
public class TbItemCat extends BasePO {
    /**
     * 类目ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @Column(name = "parent_id")
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    @Column(name = "sort_order")
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    @Column(name = "is_parent")
    private Boolean isParent;
}