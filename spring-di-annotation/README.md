#### 基于注解注入


项目开始

1. 引入spring-context依赖
2. 声明组件扫描器
3. 创建实体类
4. 在实体类上标注@Component注解，创建bean
5. 通过注解@value给简单类型属性赋值
6. 通过@Autowired给引用类型属性赋值
7. 测试类


###### 声明组件扫描器
    <context:component-scan base-package="com.ljs.entity" />


###### 定义bean的注解

    @Component 基础注解
    
    @Repository
    @Service
    @Controller


这些注解作用



    1. 定义
    2. 注册bean到spring容器中。
    3. 告诉spring创建bean 
    4. 创建bean

@Component

    属性value, 指定bean的id
    属性required，默认为true, 如果注入失败，终止程序运行。




#### 简单属性注入@Value()

可以作用到属性或者setter方法上。

    @Value("北京大学")
    private String name;
    @Value("${school.address}")
    private String adress;

这种@Value("$school.address") 需要配置读取配置文件


    <!--读取属性配置文件, classpath: 从类路径中获取文件 -->
    <context:property-placeholder location="classpath:school.properties"/>

#### 引用类型的自动注入 @AutoWired

    @AutoWired; 可以byName, byType自动注入，默认是byType自动注入。


如果需要byName自动注入；需要结合@Qualifier(value="bean的id")
目测可以指定注入唯一bean，



    @Autowired
    @Qualifier(value = "school")
    private School school;



#### 引用类型的自动注入，使用@Resource

    属性：
        name = "bean 的id";
    
    1）默认是通过byName自动注入，如果byName失败，就会通过byType进行自动注入
    2）如果设置了name的属性，只能通过byName注入。


@Resource 只有在jdk 1.8使用，以上需要引入javax.annotation依赖

    
      @Resource(name = "school")
      private School school;


