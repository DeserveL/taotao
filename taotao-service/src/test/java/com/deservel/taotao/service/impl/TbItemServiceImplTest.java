package com.deservel.taotao.service.impl;

import com.deservel.taotao.service.AbstractSpringContextTest;
import com.deservel.taotao.service.TbItemService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author DeserveL
 * @date 2017/10/20 14:39
 * @since 1.0.0
 */
public class TbItemServiceImplTest extends AbstractSpringContextTest {

    @Autowired
    TbItemService tbItemService;

    @Test
    public void saveItem() throws Exception {

    }

    @Test
    public void queryItemList() throws Exception {
        System.out.println(tbItemService.queryItemList(1,2));
    }

}