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
package com.deservel.taotao.service;

import com.deservel.taotao.dao.TbItemCatMapper;
import com.deservel.taotao.model.po.TbItemCat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author DeserveL
 * @date 2017/2/6 13:37
 * @since 1.0.0
 */
public class catDaoTest extends AbstractSpringContextTest{

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Test
    public void test(){
        PageHelper.offsetPage(1,2);
        List<TbItemCat> tbItemCats = tbItemCatMapper.selectAll();
        PageInfo<TbItemCat> tbItemCatPageInfo = new PageInfo<>(tbItemCats);
        System.out.println(tbItemCats);
        System.out.println(tbItemCatPageInfo);
    }
}
