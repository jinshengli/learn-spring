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
    
      <settings>
            <setting name="logImpl" value="STDOUT_LOGGING"></setting>
            <setting name="mapUnderscoreToCamelCase" value="true"/>
            <setting name="useGeneratedKeys" value="true"/>
        </settings>
    
        <typeAliases>
            <package name="com.ljs.entity"/>
        </typeAliases>
    
    
        <!-- 加载映射文件 mapper -->
        <mappers>
            <mapper resource="mapper/StudentDao.xml"></mapper>
        </mappers>

6. spring的配置文件
    
        1. 定义druid数据源bean
        
        <!--读取配置文件进来-->
        <context:property-placeholder location="classpath:mysql.properties"/>
    
        <bean id="datasource" class="com.alibaba.druid.pool.DruidDataSource">
            <property name="url" value="${jdbc.url}"/>
            <property name="username" value="${jdbc.username}"/>
            <property name="password" value="${jdbc.password}"/>
        </bean>
        
        2. 注册SqlSessionFactoryBean；用来生成SqlSessionFactory; 需要的属性值为：数据源，mybatis的配置文件。
        
          <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
                <property name="dataSource" ref="datasource"/>
                <property name="configLocation" value="classpath:mybatis.xml"/>
          </bean>
            
        3. 注册mapper扫描器 MapperScannerConfigurer;用来创建mapper代理对象到spring ioc中
           
           因为使用它根据dao创建mapper代理对象；需要属性值，sqlSessionFatoryBeanName; 所有dao接口的包名。
            
           <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
                <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
                <property name="basePackage" value="com.ljs.dao"/>
            </bean>
           
        4. 注册service bean

7. 测试类
 
