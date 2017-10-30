package com.deservel.taotao.model.po;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;

/**
 * @author Deservel
 */
@Data
@Table(name = "tb_item_param_item")
public class TbItemParamItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 商品ID
     */
    @Column(name = "item_id")
    private Long itemId;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    /**
     * 参数数据，格式为json格式
     */
    @Column(name = "param_data")
    private String paramData;
}