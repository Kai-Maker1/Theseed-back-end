package com.seed.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/8 22:30
 */
@Component
public class RedisLock {
    private static Logger logger= LoggerFactory.getLogger(RedisLock.class);
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     *加锁
     * @param key
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key,String value){
        /*setnx*/
        if(redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;//成功加锁
        }
        String currentValue=redisTemplate.opsForValue().get(key);
        //若锁过期（解决死锁问题）
        if(!StringUtils.isEmpty(currentValue)
                &&Long.parseLong(currentValue)<System.currentTimeMillis()){
            //获取上一个所的时间 (当多个线程访问以下代码时，保证h只有一个线程拿到锁)
            String oldValue=redisTemplate.opsForValue().getAndSet(key,value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {

                redisTemplate.opsForValue().getOperations().delete(key);

            }
        }catch (Exception e){
            logger.error("【redis分布式锁】解锁异常，{}",e);
        }
    }
}
