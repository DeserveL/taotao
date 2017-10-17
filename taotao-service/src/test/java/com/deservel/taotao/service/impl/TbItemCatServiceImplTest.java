package com.deservel.taotao.service.impl;

import com.deservel.taotao.service.AbstractSpringContextTest;
import com.deservel.taotao.service.TbItemCatService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author DeserveL
 * @date 2017/10/17 0017 下午 22:18
 * @since 1.0.0
 */
public class TbItemCatServiceImplTest extends AbstractSpringContextTest {
    @Autowired
    private TbItemCatService tbItemCatService;

    @Test
    public void queryItemCat() throws Exception {
        System.out.println(this.tbItemCatService.queryItemCat(0L));
    }

}