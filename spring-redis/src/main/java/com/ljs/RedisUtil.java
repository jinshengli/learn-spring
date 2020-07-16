package com.ljs;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * create by ljs on 2020/7/16 20:54
 * description:
 */
public class RedisUtil {


    public static void main(String[] args) {

        String config = "applicationContext.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);

        JedisPool jedisPool = (JedisPool) context.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();

        Set<String> keys = jedis.keys("*");

        System.out.println(keys);


    }


}
