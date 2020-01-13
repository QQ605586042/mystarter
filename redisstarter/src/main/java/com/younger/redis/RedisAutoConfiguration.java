package com.younger.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
@ConditionalOnClass(Jedis.class)
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnProperty(prefix = "redis", value = "enabled", matchIfMissing = true)
public class RedisAutoConfiguration {
    private final Logger logger = LoggerFactory.getLogger(RedisAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public Jedis jedis(RedisProperties redisProperties) {
        logger.info("-------------------->要初始化jedis啦");
        logger.info("host:"+redisProperties.getHost()+" port:"+redisProperties.getPort());
        Jedis jedis = new Jedis(redisProperties.getHost(), redisProperties.getPort());
        return jedis;
    }
}
