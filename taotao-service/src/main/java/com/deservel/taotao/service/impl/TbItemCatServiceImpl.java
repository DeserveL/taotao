/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.deservel.taotao.service.impl;

import com.deservel.taotao.model.po.TbItemCat;
import com.deservel.taotao.model.vo.ItemCatDataVO;
import com.deservel.taotao.model.vo.ItemCatResultVO;
import com.deservel.taotao.model.vo.TbItemCatVO;
import com.deservel.taotao.service.AbstractBaseService;
import com.deservel.taotao.service.TbItemCatService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DeserveL
 * @date 2017/10/16 16:36
 * @since 1.0.0
 */
@Service
public class TbItemCatServiceImpl extends AbstractBaseService<TbItemCat> implements TbItemCatService {

    /**
     * 查询商品分类list
     *
     * @param parentId
     * @return
     */
    @Override
    public List<TbItemCatVO> queryItemCat(Long parentId) {
        //返回值
        List<TbItemCatVO> tbItemCatVOs = new ArrayList<>();

        TbItemCat tbItemCat = new TbItemCat();
        tbItemCat.setParentId(parentId);
        List<TbItemCat> select = this.queryListByWhere(tbItemCat);
        if (null != select) {
            for (TbItemCat itemCat : select) {
                TbItemCatVO tbItemCatVO = new TbItemCatVO();
                tbItemCatVO.setId(itemCat.getId());
                tbItemCatVO.setParentId(itemCat.getParentId());
                tbItemCatVO.setText(itemCat.getName());
                tbItemCatVO.setState(itemCat.getIsParent() ? "closed" : "open");
                tbItemCatVOs.add(tbItemCatVO);
            }
        }
        return tbItemCatVOs;
    }

    /**
     * 单个分类详情
     *
     * @param id
     * @return
     */
    @Override
    public TbItemCat queryItemCatById(Long id) {
        return this.queryById(id);
    }

    /**
     * 商品分类树
     *
     * @return
     */
    @Override
    public ItemCatResultVO queryItemCatTree() {
        //获取全部数据
        List<TbItemCat> cats = super.queryAll();

        //转为map存储，key为父节点ID，value为数据集合
        Map<Long, List<TbItemCat>> itemCatMap = new HashMap<>(16);
        for (TbItemCat itemCat : cats) {
            //查看是否存在父节点数据，没有则创建
            if (!itemCatMap.containsKey(itemCat.getParentId())) {
                itemCatMap.put(itemCat.getParentId(), new ArrayList<>());
            }
            //加入到父节点中
            itemCatMap.get(itemCat.getParentId()).add(itemCat);
        }

        ItemCatResultVO result = new ItemCatResultVO();
        List<ItemCatDataVO> itemCatDataVOs = new ArrayList<>();
        result.setItemCats(itemCatDataVOs);
        //从顶级节点开始遍历
        List<TbItemCat> tbItemCatFirst = itemCatMap.get(0L);
        for (TbItemCat itemCat : tbItemCatFirst) {

            ItemCatDataVO itemCatData = new ItemCatDataVO();
            itemCatData.setUrl("/products/" + itemCat.getId() + ".html");
            itemCatData.setName("<a href='" + itemCatData.getUrl() + "'>" + itemCat.getName() + "</a>");
            result.getItemCats().add(itemCatData);
            if (!itemCat.getIsParent()) {
                continue;
            }

            // 封装二级对象
            List<TbItemCat> itemCatList2 = itemCatMap.get(itemCat.getId());
            List<ItemCatDataVO> itemCatData2 = new ArrayList<>();
            itemCatData.setItems(itemCatData2);
            for (TbItemCat itemCat2 : itemCatList2) {
                ItemCatDataVO id2 = new ItemCatDataVO();
                id2.setName(itemCat2.getName());
                id2.setUrl("/products/" + itemCat2.getId() + ".html");
                itemCatData2.add(id2);
                if (itemCat2.getIsParent()) {
                    // 封装三级对象
                    List<TbItemCat> itemCatList3 = itemCatMap.get(itemCat2.getId());
                    List<String> itemCatData3 = new ArrayList<>();
                    id2.setItems(itemCatData3);
                    for (TbItemCat itemCat3 : itemCatList3) {
                        itemCatData3.add("/products/" + itemCat3.getId() + ".html|" + itemCat3.getName());
                    }
                }
            }
            if (result.getItemCats().size() >= 14) {
                break;
            }
        }

        return result;
    }
}
