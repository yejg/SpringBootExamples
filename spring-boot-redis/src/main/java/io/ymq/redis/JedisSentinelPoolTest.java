package io.ymq.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * 验证redis的主从切换
 *
 * @author yejg
 * @since 2020-06-10
 */
public class JedisSentinelPoolTest {

    public static final String MASTER_NAME = "xpe-yejg";

    private static JedisSentinelPool jedisPool = null;

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            try {
                hset("yejgTest", "k" + i, "v" + i);
                Thread.currentThread().sleep(1000);
            } catch (Exception e) {
                System.out.println("出现异常" + e.getMessage());
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e1) {

                }
            }
        }
        System.out.println("---------------------------------------");
    }

    private static boolean hset(String key, String field, String value) {
        JedisSentinelPool jedisSentinelPool = jedisSentinelPool();
        Jedis jedis = jedisSentinelPool.getResource();
        try {
            Long result = jedis.hset(key, field, value);
            System.out.println("当前master节点：" + jedisSentinelPool.getCurrentHostMaster().toString() +
                    "；   jedis对象信息：" + jedis.toString() +
                    "；   设置" + key + "，key=" + field + ", value=" + value);
            if (result == 1 || result == 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            jedis.close();
        }
    }

    private static JedisSentinelPool jedisSentinelPool() {
        if (jedisPool == null) {
            Set<String> sentinels = new HashSet<String>();
            sentinels.add("127.0.0.1:26379");
            sentinels.add("127.0.0.1:26380");
            sentinels.add("127.0.0.1:26381");
            JedisPoolConfig config = new JedisPoolConfig();
            jedisPool = new JedisSentinelPool(MASTER_NAME, sentinels, config);
        }
        return jedisPool;
    }

}
