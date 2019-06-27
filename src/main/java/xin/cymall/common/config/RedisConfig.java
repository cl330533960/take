package xin.cymall.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@EnableCaching
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    
	 /*
     * 去除value双引号
     * @date:2019-06-18
     * @updateBy:lxj
     */
    @Bean(name="redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);           
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);       
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();        
        template.setConnectionFactory(redisConnectionFactory);        
        template.setKeySerializer(new StringRedisSerializer());        
        template.setValueSerializer(new StringRedisSerializer());        
        template.setHashKeySerializer(jackson2JsonRedisSerializer);       
        template.setHashValueSerializer(jackson2JsonRedisSerializer);        
        template.afterPropertiesSet();       
        return template;
    }
    
}