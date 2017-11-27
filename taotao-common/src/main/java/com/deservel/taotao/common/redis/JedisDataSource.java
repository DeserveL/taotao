package com.deservel.taotao.common.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Jedis实例的生成和回收
 *
 * @author DeserveL
 * @date 2017/11/27 0027 下午 20:24
 * @since 1.0.0
 */
public interface JedisDataSource {
    /**
     * 获取
     *
     * @return
     */
    ShardedJedis getRedisClient();

    /**
     * 回收
     *
     * @param shardedJedis
     */
    void returnResource(ShardedJedis shardedJedis);

    /**
     * 回收
     *
     * @param shardedJedis
     * @param broken
     */
    void returnResource(ShardedJedis shardedJedis, boolean broken);
}
