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
package com.deservel.taotao.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;

/**
 * Jedis操作类(部分片段)
 *
 * @author DeserveL
 * @date 2017/11/27 0027 下午 20:35
 * @since 1.0.0
 */
@Component
public class RedisClientTemplate {

    @Autowired
    private JedisDataSource jedisDataSource;

    /**
     * 具体执行操作
     *
     * @param fun
     * @param <T>
     * @return
     */
    public <T> T execute(Function<T, ShardedJedis> fun) {
        ShardedJedis redisClient = null;
        try {
            redisClient = jedisDataSource.getRedisClient();
        } finally {
            if (null != redisClient) {
                jedisDataSource.returnResource(redisClient);
            }
        }
        return fun.callback(redisClient);
    }

    /**
     * 设置单个值
     *
     * @param key
     * @param value
     * @return
     */
    public String set(final String key, final String value) {
        return this.execute(shardedJedis -> shardedJedis.set(key, value));
    }

    /**
     * 获取单个值
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        return this.execute(shardedJedis -> shardedJedis.get(key));
    }

    /**
     * 执行删除操作
     *
     * @param key
     * @return
     */
    public Long del(final String key) {
        return this.execute(e -> e.del(key));
    }


    /**
     * 判断
     *
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        return this.execute(shardedJedis -> shardedJedis.exists(key));
    }

    /**
     * 类型
     *
     * @param key
     * @return
     */
    public String type(String key) {
        return this.execute(shardedJedis -> shardedJedis.type(key));
    }

    /**
     * 在某段时间后失效
     *
     * @param key
     * @param seconds
     * @return
     */
    public Long expire(String key, int seconds) {
        return this.execute(shardedJedis -> shardedJedis.expire(key, seconds));
    }

    /**
     * 在某个时间点失效
     *
     * @param key
     * @param unixTime
     * @return
     */
    public Long expireAt(String key, long unixTime) {
        return this.execute(shardedJedis -> shardedJedis.expireAt(key, unixTime));
    }
}
