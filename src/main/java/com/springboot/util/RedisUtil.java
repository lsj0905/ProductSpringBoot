package com.springboot.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//@SuppressWarnings("unchecked")
@Component
public class RedisUtil {
//    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public String get(final String key) {
        Object result = null;
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Serializable> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        if (result == null) {
            return null;
        }
        return result.toString();
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            redisTemplate.opsForValue().set(key, (Serializable) value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<String, Serializable> operations = redisTemplate.opsForValue();
            operations.set(key, (Serializable) value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 在列表的左侧添加
     * @param key
     * @param value
     * @return
     */
    public boolean lset(final String key,String value){
        boolean result=false;
        try {
            redisTemplate.opsForList().leftPush(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 在列表的右侧添加
     * @param key
     * @param value
     * @return
     */
    public boolean Rlset(final String key,String value){
        boolean result=false;
        try {
            redisTemplate.opsForList().rightPush(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取指定数量的元素
     * @param key
     * @param count
     * @return
     */
    public List<Serializable> lrang(final String key,int index,int count){
        boolean result=false;
        List<Serializable> list=null;
        try {
            list=redisTemplate.opsForList().range(key,index,count);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 在列表的右侧添加
     * @param key
     * @param value
     * @return
     */
    public boolean lremove(final String key,long count,Object value){
        boolean result=false;
        try {
            redisTemplate.opsForList().remove(key,count,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }



    public boolean hmset(String key, Map<String, String> value) {
        boolean result = false;
        try {
            redisTemplate.opsForHash().putAll(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Map<Object, Object> hmget(String key) {
        Map<Object, Object> result = null;
        try {
            result = redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean   hincre(String testmap, String s) {

        boolean b=false;
        try {

            redisTemplate.opsForHash().increment(testmap,s,1);
            b=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return b;
    }
}

