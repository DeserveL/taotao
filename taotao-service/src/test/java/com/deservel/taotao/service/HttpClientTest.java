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

import com.deservel.taotao.common.httpclient.HttpClientApi;
import com.deservel.taotao.common.httpclient.HttpResult;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @author DeserveL
 * @date 2017/11/28 15:01
 * @since 1.0.0
 */
public class HttpClientTest extends AbstractSpringContextTest {

    @Autowired
    HttpClientApi httpClientApi;

    @Test
    public void doGet() throws IOException {
        String httpResult = httpClientApi.doGet("http://192.168.3.52:8080/api/user/list");
        System.out.println(httpResult);
    }

    @Test
    public void doPost() throws IOException {
        HttpResult httpResult = httpClientApi.doPost("http://192.168.3.52:8080/api/user/list");
        System.out.println(httpResult);
    }
}
