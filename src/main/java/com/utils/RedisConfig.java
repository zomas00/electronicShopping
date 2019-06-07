package com.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


@PropertySource(value = "classpath:redis.properties")
public class RedisConfig {

    @Value("${redis.hostName}")
    private String hostName;
    @Value("${redis.port}")
    private int port;
    @Value("${redis.password}")
    private String password;

    @Value("${redis.maxTotal}")
    private int maxTotal;
    @Value("${redis.maxIdle}")
    private int maxIdle;
    @Value("${redis.minIdle}")
    private int minIdle;

    @Value("${redis.maxWaitMillis}")
    private int maxWaitMillis;
    @Value("${redis.blockWhenExhausted}")
    private boolean blockWhenExhausted;
    @Value("${redis.testOnBorrow}")
    private boolean testOnBorrow;

    //配置Jedis连接池配置对象
    @Autowired
    private JedisPoolConfig poolConfig;
    //配置Jedis连接工厂
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;
    @Bean
    public JedisPoolConfig getPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置连接池的特性
        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        return jedisPoolConfig;
    }
    @Bean
    public JedisConnectionFactory getJedisConnectionFactory(){
        //单主机模式（还有主从模式与集群模式与哨兵模式）
        RedisStandaloneConfiguration redisStandaloneConfig = new RedisStandaloneConfiguration();
        //设置连接的特性
        redisStandaloneConfig.setHostName(hostName);
        redisStandaloneConfig.setPort(port);
        redisStandaloneConfig.setPassword(RedisPassword.of(password));//关键
        //用于jedis的Redis客户机配置。这个配置提供了一些可选的配置元素，
        //比如特定于jedis客户端特性的SSLSocketFactory和JedisPoolConfig。
        //提供可选的元素允许客户端更具体的配置（JedisClientConfiguration接口）
        //静态方法JedisPoolingClientConfigurationBuilder用来构建与连接池有关的客户端配置
        //builder方法用于使用此构建器应用的配置构建JedisClientConfiguration。
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder
                jedisPoolConfigBuilder = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder)
                JedisClientConfiguration.builder();
        //使用Jedis连接池配置对象
        jedisPoolConfigBuilder.poolConfig(poolConfig);
        //创建了使用给定的连接池配置构建连接工厂对象
        JedisConnectionFactory jedisConnectionFactory =
                new JedisConnectionFactory
                        (redisStandaloneConfig,jedisPoolConfigBuilder.build());
        return jedisConnectionFactory;
    }
    //模板对象
    @Bean
    public RedisTemplate redisTemplate(){
        //序列化，数据以string存储
        RedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //序列化，数据以json进行存储
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer=new GenericJackson2JsonRedisSerializer();
        //模板对象
        RedisTemplate redisTemplate = new RedisTemplate();
        //设置模板对象的连接工厂
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        //设置模板对象键值的序列化方式（String）
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(genericJackson2JsonRedisSerializer);
        //设置模板对象键值的序列化方式（Hash类型）
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        return redisTemplate;

    }
}
