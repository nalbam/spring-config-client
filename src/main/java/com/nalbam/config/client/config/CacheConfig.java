package com.nalbam.config.client.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@EnableCaching
@Configuration
public class CacheConfig extends CachingConfigurerSupport {

    @Value("${spring.redis.host:localhost}")
    private String host;

    @Value("${spring.redis.database:5}")
    private Integer database;

    @Value("${spring.redis.expire.seconds:3600}")
    private Integer expireTime; // seconds

    @Bean
    public CacheManager cacheManager(final RedisTemplate redisTemplate) {
        final RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(this.expireTime);
        return cacheManager;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(final RedisConnectionFactory redisConnectionFactory) {
        final StringRedisTemplate template = new StringRedisTemplate(redisConnectionFactory);
        final ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.setSerializationInclusion(Include.NON_EMPTY);
        final GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        final JedisConnectionFactory conn = new JedisConnectionFactory();
        conn.setHostName(this.host);
        conn.setDatabase(this.database);
        conn.setUsePool(true);
        return conn;
    }

}
