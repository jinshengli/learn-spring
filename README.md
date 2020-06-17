### spring


#### spring ioc

创建容器
    
    String config = "beans.xml";
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
    

#### spring xml-DI

属性赋值：

1. set注入注入

        简单类型
            <property name="" value=""/>
        引用类型
            <property name="" ref="xxid"/>
        
    
2. 构造注入

        

3. 引用类型自动注入


4. 多配置文件。



#### spring-annotation-DI

1. 声明组件扫描器
2. 使用组件声明spring bean
3. @Value简单类型注入
4. @AutoWired引用类型注入
5. @Resource同上，默认模式不太一样


#### spring-aop

使用aspect的aop注解实现aop功能

1. 引入spring-aspect依赖
2. 开启自动代理生成器
3. 定义切面类
4. 将切面类交给spring


#### spring-mybatis

spring整合mybatis。 基本思路是由spring创建和维护mybatis
中的一些必要对象。比如SqlSessionFactory, Dao动态代理对象。



#### spring-transaction

使用spring事务。


#### spring-web

