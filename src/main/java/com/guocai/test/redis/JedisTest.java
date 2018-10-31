package com.guocai.test.redis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

/**
 * java类简单作用描述
 *
 * @ClassName: JedisTest
 * @Package: com.guocai.test.redis
 * @Description: 测试Redis
 * @Author: Sun GuoCai
 * @Version: 1.0
 * @Create: 2018-10-17-20:58
 */
public class JedisTest {


    @Test
    public void testJedisSingle() {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.254.135", 6379);
        //调用jedis对象的方法，方法名称和redis 的命令一致
        jedis.set("key2", "jedis test2");
        String string = jedis.get("key1");
        System.out.println(string);
        //关闭jedis
        jedis.close();
    }


    /**
     *使用jedis连接池
     */
    @Test
    public void testJedisPool(){
        JedisPool jedisPool = new JedisPool("1192.168.254.135", 6379);
        //获得jedis 连接对象
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("key1"));
        jedis.close();
    }
    /**
     * 集群连接测试
     */
    @Test
    public void testJedisCluster(){
        Set<HostAndPort> nodes = new HashSet<HostAndPort>();
        nodes.add(new HostAndPort("192.168.254.135", 7001));
        nodes.add(new HostAndPort("192.168.254.135", 7002));
        nodes.add(new HostAndPort("192.168.254.135", 7003));
        nodes.add(new HostAndPort("192.168.254.135", 7004));
        nodes.add(new HostAndPort("192.168.254.135", 7005));
        nodes.add(new HostAndPort("192.168.254.135", 7006));
        nodes.add(new HostAndPort("192.168.254.135", 7007));
        nodes.add(new HostAndPort("192.168.254.135", 7008));
        JedisCluster cluster = new JedisCluster(nodes );
        cluster.set("key1", "1000");
        System.out.println(cluster.get("key1"));
    }

}
