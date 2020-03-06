package com.seed.redis;

import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Li Yawei
 * @Date: 2019/3/10 15:42
 */
@Configuration
public class RedisCacheConfig {

        @Bean
        public KeyGenerator keyGenerator() {
            return (o, method, objects) -> {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(o.getClass().getSimpleName());
                stringBuilder.append(".");
                stringBuilder.append(method.getName());
                stringBuilder.append("[");
                for (Object obj : objects) {
                    stringBuilder.append(obj.toString());
                }
                stringBuilder.append("]");

                return stringBuilder.toString();
            };
        }

        @Bean
        public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
            return new RedisCacheManager(
                    RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory),
                    this.getRedisCacheConfigurationWithTtl(4400),   // 默认策略，未配置的 key 会使用这个
                    this.getRedisCacheConfigurationMap() // 指定 key 策略
            );
        }

        private Map<String, RedisCacheConfiguration> getRedisCacheConfigurationMap() {
            Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
            redisCacheConfigurationMap.put("UserInfoList", this.getRedisCacheConfigurationWithTtl(3000));
            redisCacheConfigurationMap.put("UserInfoListAnother", this.getRedisCacheConfigurationWithTtl(18000));

            return redisCacheConfigurationMap;
        }

        private RedisCacheConfiguration getRedisCacheConfigurationWithTtl(Integer seconds) {

            /*Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
            ObjectMapper om = new ObjectMapper();
            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
            jackson2JsonRedisSerializer.setObjectMapper(om);*/

            RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
            redisCacheConfiguration = redisCacheConfiguration
                                .serializeKeysWith(
                                        RedisSerializationContext
                                                .SerializationPair
                                                .fromSerializer(new StringRedisSerializer()))
                                .serializeValuesWith(
                                        RedisSerializationContext
                                                .SerializationPair
                                                .fromSerializer(new GenericJackson2JsonRedisSerializer()))
                                .entryTtl(Duration.ofSeconds(seconds));

        /*
        .serializeValuesWith(
                    RedisSerializationContext
                            .SerializationPair
                            .fromSerializer(jackson2JsonRedisSerializer)
            ).entryTtl(Duration.ofSeconds(seconds));*/

            return redisCacheConfiguration;
        }
}
