##### spring 和 Mybatis 整合

思路：将mybatis框架几个必要的对象，交给spring来创建和管理。


1. 引入依赖
    1. 引入spring-context依赖
    2. 引入mybatis-spring依赖
    3. 引入mysql connector 驱动
    4. 引入druid数据源

2. 创建dao接口，dao对应的Mapper映射文件

3. 创建创建service层接口，接口实现类

4. 配置mybatis的配置文件
    
    1. 配置<setting> 日志，mapUnderscoreToCamelCase
    2. 实体类的别名 <typeAliases>
    3. 配置映射器；  <mappers>

6. spring的配置文件
    
    1. 定义druid数据源bean
    2. 注册SqlSessionFactoryBean；用来生成SqlSessionFactory
    3. 注册mapper扫描器 MapperScannerConfigurer;用来创建mapper代理对象到spring ioc中
    4. 注册service bean

7. 测试类
 
