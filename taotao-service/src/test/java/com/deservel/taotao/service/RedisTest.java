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

import com.deservel.taotao.common.redis.RedisClientTemplate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author DeserveL
 * @date 2017/11/27 0027 下午 20:56
 * @since 1.0.0
 */
public class RedisTest extends AbstractSpringContextTest {

    @Autowired
    RedisClientTemplate redisClientTemplate;

    @Test
    public void exist() {
        boolean a = redisClientTemplate.exists("a");
        String a1 = redisClientTemplate.get("a");
        String a2 = redisClientTemplate.type("a");
        System.out.println(a);
        System.out.println(a1);
        System.out.println(a2);
    }
}
