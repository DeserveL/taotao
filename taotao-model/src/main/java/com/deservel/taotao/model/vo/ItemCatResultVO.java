package com.deservel.taotao.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 前端商品分类
 *
 * @author
 */
@Data
public class ItemCatResultVO {

	@JsonProperty("data")
	private List<ItemCatDataVO> itemCats;

}
