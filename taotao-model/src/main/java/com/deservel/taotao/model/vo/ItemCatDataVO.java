package com.deservel.taotao.model.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 前端商品分类
 *
 * @author deservel
 */
@Data
public class ItemCatDataVO {

	/**
	 * 序列化成json数据时为 u
	 */
	@JsonProperty("u")
	private String url;
	
	@JsonProperty("n")
	private String name;
	
	@JsonProperty("i")
	private List<?> items;

}
