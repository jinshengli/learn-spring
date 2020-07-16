
## redis 命令总结

k，v 对的形式存储。


#### 对redis 数据库操作

    1. 
        dbsize
        
        查看当前数据库key的数目
    
    2.  select [0-15]
        
        切换数据库； 默认16个库
    
    3. flushdb
        
        删除当前库的数据   
    

#### redis 的key操作命令

    1. keys pattern
        
       use: 查找符合 pattern 的key
       
       例子：
            keys * // 返回当前库全部key
            
    2. exists
    
        语法：exists key [key...]
        use: 判断key是否存在
        return:
            1: key存在 
            0: key不存在
            某个整数：该判断存在多少个key
    
    3. expire
        
        语法：expire key seconds
        use: 设置key的存活时间，超时后自动删除
        return：
            1：成功执行
            0：失败
    
    4. ttl
        
        语法：ttl key
        use: 返回key的剩余生存时间；单位秒
        return: 
            -1: key没有设置生存时间，永不过期
            -2：key 不存在
            其他数字：key的剩余时间，秒为单位
            
    5. type
        
        语法：type key     
        use: 查看key对应值的数据类型
        return：  字符串表示的数据类型           
               none (key 不存在)
               string
               list
               set 
               zset
               hash
                       
                   
    6. del
        
        语法：del key [key...]
        作用： 删除存在的key, 不存在的key忽略
        return:
            删除的key数量
    
            
    

#### 字符串类型 （String）

     1. set 
        
        语法：set key value
        use: 添加或者修改 key 对应的字符串值。
    
    
    2. get 
        
        语法：get key
        use: 获取key中对应的字符串
        
    
    3. append
        
        语法：append key value
        use： 最佳字符串、
        return: 追加后value的总长度
        
    
    4. strlen
        
        语法： strlen key
        use: 求字符串值的长度。
        return： 
            0：key不存在
            其他：字符串的长度
    
    5. getrange
        
        语法： getrange key start end
        use: 截取[start,end]范围内字符串； ps end = -1; 代表到末尾
        return：
            [start,end] 范围内的字符串           
        
    6. setrange    
        
        语法： setrange key offset value
        use: offset位置后面使用value替换
        return: 修改后字符串的长度
        
    7. mset 
        
        语法： mset key value [key value ...]
        use: 一次性设置多个 key-value 对
        
    8. mget
        
        语法： mget key [key ...]
        use: 一次性获取多个key 对应的string
        return: 多个 key 对应的string 列表
        
    
    9. incr
        
        语法：incr key
        use: 针对String 是整数类型，加一
        
    10. decr 
        
        语法： decr key
        use: 减一；    
        

#### 哈希类型 hash

    redis hash 是一个 string 类型的 field 和 value 的映射表，
    hash 特别适合用于存储对象。

    
    1. hset
        
        语法：hset key field value
        use: 给key对应的hash表 设置一个叫field的域，设置为value
            1）原来存在field的域，覆盖原来的value
            2）原来不存在，添加一个新的value
        
        return:
            1) 添加field域，返回1
            2） 覆盖原来的field域的值，返回0
                
    
    
    2. hget
        
        语法： hset key field
        use:  获取哈希表key中的给定域field的值。
        
        return：
            
             域存在，field域的值，
             域不存， nil
    
    3. hmset
        
        语法： hmset key field value [field value ...]
        use: 一次性添加多个 field-value [域-值]到hash表key中
        
    4. hmget
    
        语法：hmget key field [field ...]
        use: 一次性获取哈希表key中多个给定域的值
        
        return: 和field顺序对应的值，field不存在，返回nil
    
    5. hgetall    
        
        语法：hgetall key
        use: 以列表形式返回hash中域和域的值，key不存在，返回nil
        
                  
    6. hdel
        
        语法：hdel key field [field...]
        use: 删除哈希表key中的一个或多个域，不存在的域，直接忽略
        返回值： 成功删除的field的数量        
    
    7. hkeys
        
        语法：hkeys key
        use: 查看哈希表key中的所有field域
        
        return：  所有field的列表； key 不存在，返回nil
    
    
    8. hvals
        
        语法： hvals key
        use: 返回哈希表中所有域的值
        
        return： 所有域值的列表
    
    9. hexists
        
        语法： hexists key field
        use: 判断哈希表key中是否存在field的域。
        
        return：
            域存在，返回1
            不存在：放回0
            
                    
### 列表 List

Redis 列表是简单的字符串列表，按照插入顺序排序。
你可以添加一个元素导列表的头部（左边）或者尾部（右边）

    
    1.lpush
    
    语法： lpush key value [value ...]
    use： 每次一组 valeu 到数组key中，每次都是中左边添加元素
    
    return: 新数组的长度
     
     例子：lpush mylist:l a b c 
        
          lrange mylist:1 0 -1
          [c, b, a]    
    
    2. rpush
    
        语法：rpush key value [value ...]
        use: 将一个或者多个值value插入到列表key的末尾，value从左到右依次插入。
        
        return: 新数组的长度 
     
    3. lrange
        
        语法：lrange key start stop
        use: 获取列表key中指定区间内的元素，[start,stop]
        
        return:  [star,stop]之间的列表元素
        
    4. lindex
        
        语法：lindex key index
        use: 获取列表key指定下标index的元素    
    
        return: 
                1. 存在index下标的元素
                2. 不存在，返回nil
    
    4. llen
        
        语法： llen key
        use: 获取列表key的长度
        
        return: 
               
               1. key存在， 列表长度
               2. 不存在， 返回0            
    
    
    5. lrem
        
        语法： lrem key count value
        use:  从列表key中删除值为value的元素；
              1）count>0，从左到右依次删除count个 value
              2）count<0, 从右到左删除count个 value
              3）count=0, 删除所有value元素
              
        return: 移除元素的个数。      
        
    
    6. lset
    
        语法： lset key index value
        use: 修改列表key中下标为index的值
        
        
    7. linsert 
    
        语法：linsert key before|after pivot value
        use: 在pivot 前或者后插入值为value的元素
        
        return: 
            
            成功：新列表的长度
            pivot不存在：-1
            key不存在： 0
                

#### 集合类型 set

redis 的 Set 是 string 类型的无序集合，
集合成员是唯一的，即集合中不能出现重复的数据



###### 基本命令

    1. sadd 
    
        语法：sadd key member [member...]
        
        
    
    2. smembers
    
        语法：smembers key
        
    
    3. sismember
    
        语法：sismember key member
    
    
    4. scard
        
        语法：scard key
                 
    5. srem 
        
        语法： srem key member [member ...]
        
    
    6. srandmember 
        
        语法： srandmember key count
                
    
    7. spop 
        
        语法： spop key count



#### 有序集合类型 zset （sorted set）

redis 有序集合zset和集合set一样也是string类型元素的集合，且不允许重复的成员。
不同的是 zset 的每个元素都会关联一个分数（分数可以重复），redis 通过分数来为集合中的成员进行从小到大的排序。


##### zset 基本命令

    
    1. zadd 
        
        语法： zadd key score member [score member]
        
    
    2. zrange
        
        语法： zrange key start stop [withscores]
            
    
    3. zrevrange 
        
        语法： zrevrange key start stop [withscores]
    
    5. zrem 
    
        语法：zrem key member [member ...]
        
    6. zcard 
    
        语法： zcard key
        
    7. zrangebyscore
    
        语法： zrangebyscore key min max [withscores] [limit offset count]
    
    8. zrevrangebysocre
        
        语法：zrevrangebyscore key min max [withscores] [limit offset count]
    
    
    9. zcount key min max        
            
                    