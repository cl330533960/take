package xin.cymall.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName JwtRedisService
 * @Author cailei
 * @Description
 * @Date 2019/4/13 15:05
 **/
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        try {
        	getValueOperations(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        try {
        	getValueOperations(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.MILLISECONDS);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 批量删除对应的value
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }
    /**
     * 删除对应的value
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    /**
     * @哈希 添加  待用的时候进行修改
     * @param key
     * @param hashKey
     * @param value
     */
    /*public void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }*/

    /**
     * @哈希获取数据 待用的时候进行修改
     * @param key
     * @param hashKey
     * @return
     */
    /*public Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }*/

    /**
     * @列表添加 待用的时候进行修改
     * @param k
     * @param v
     */
   /* public void lPush(String k,Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
    }*/

    /**
     * @列表获取 待用的时候进行修改
     * @param k
     * @param l
     * @param l1
     * @return
     */
    /*public List<Object> lRange(String k, long l, long l1){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
    }*/

    /**
     * @集合添加
     * @param key
     * @param value
     */
    public void add(String key,Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        if(value instanceof String) {
        	set.add(key,value);
	    }else {
	    	set.add(key, JSON.toJSONString(value));
	    }
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public Set<Object> setMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * @ 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(String key,Object value,double scoure){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        if(value instanceof String) {
        	zset.add(key,value,scoure);
	    }else {
	    	zset.add(key, JSON.toJSONString(value),scoure);
	    }
    }

    /**
     * @有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public Set<Object> rangeByScore(String key,double scoure,double scoure1){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    /**
     * @获取键列表
     * @param pattern
     * @return
     */
    public Set<Serializable> getKeys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /*
     *  获取集合key的元素个数
     * @date:2019-05-25
     * @createBy:lxj
     */
    public Long getCurrentKeyMembers(String key) {
    	SetOperations<String, Object> set = redisTemplate.opsForSet();
    	return set.size(key);
    }
    
    /*
     * @分开处理value字符串类型，防止双引号
     * @date:2019-06-18
     * @createBy:lxj
     */
    private ValueOperations<Serializable, Object> getValueOperations(String key ,Object value){
    	ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
	    if(value instanceof String) {
	    	operations.set(key, value);
	    }else {
	    	operations.set(key, JSON.toJSONString(value));
	    }
	    return operations;
    }
}
