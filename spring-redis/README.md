
#### spring 集合 redis

 使用jedis操作redis
 
 
 引入连接池 JedisPool
 
 
 ###### 原理是将 JedisPool连接池交给spring管理
 
 
 
 
 #### 实验步骤
 
 
 
##### 1. 引入maven依赖
 
     <dependency>
         <groupId>redis.clients</groupId>
         <artifactId>jedis</artifactId>
         <version>2.9.3</version>
     </dependency>
     
     <dependency>
         <groupId>org.apache.commons</groupId>
         <artifactId>commons-pool2</artifactId>
         <version>2.6.0</version>
     </dependency>

##### 2. 注入bean

    <context:property-placeholder location="classpath:redis.properties"/>
    
    <bean id="jedisPoolConfig" class="redis.clients.jedis.JedisPoolConfig">
        <property name="maxTotal" value="10"/>
        <property name="maxIdle" value="3"/>
        <property name="testOnBorrow" value="true"/>
    </bean>
    
    <bean id="jedisPool" class="redis.clients.jedis.JedisPool">
        <constructor-arg name="poolConfig" ref="jedisPoolConfig"/>
        <constructor-arg name="host" value="${redis.host}"/>
        <constructor-arg name="port" value="${redis.port}"/>
    </bean>
    

 
 
##### 获取jedis实例

    Jedis jedis = new Jedis(host,port);

##### jedis连接池

    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxTotal(10);
    jedisPoolConfig.setMaxIdle(3);
    jedisPoolConfig.setTestOnBorrow(true);
    
    JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port);
    


##### String类型API

     set(final String key, final String value)
     
     String get(final String key)
     
     Long strlen(final String key)
     
     String getrange(final String key, final long startOffset, final long endOffset)
     
     Long setrange(final String key, final long offset, final String value)
     
     String mset(final String... keysvalues)
     
     List<String> mget(final String... keys)
     
     Long incr(final String key)
      
     Long decr(final String key) 
     
     
##### Hash类型API

    
    Long hset(final String key, final String field, final String value)
    
    String hmset(final String key, final Map<String, String> hash)
    
    String hget(final String key, final String field)
    
    List<String> hmget(final String key, final String... fields) 
    
    Map<String, String> hgetAll(final String key)
    
    Set<String> hkeys(final String key)
    
    List<String> hvals(final String key)
     
    Boolean hexists(final String key, final String field)
    
    Long hdel(final String key, final String... fields)
 
##### List类型API

    Long rpush(final String key, final String... strings) 
    
    Long lpush(final String key, final String... strings)
    
    List<String> lrange(final String key, final long start, final long stop)
    
    String lindex(final String key, final long index)
    
    Long llen(final String key)
    
    String lpop(final String key)
     
    String rpop(final String key)
      
    String lset(final String key, final long index, final String value)
    
    Long lrem(final String key, final long count, final String value)
    

##### Set 类型API

    Long sadd(final String key, final String... members)  
              
    Set<String> smembers(final String key)
    
    String srandmember(final String key)
    
    List<String> srandmember(final String key, final int count)
    
    Boolean sismember(final String key, final String member)
    
    Long srem(final String key, final String... members)
    
    Set<String> spop(final String key, final long count)
   
 
 
 


