
### AOP

    Aop 面向切面编程，可以通过运行期动态代理实现程序功能统一维护的技术。
    
    为了降低非业务代码和业务代码的耦合度，将非业务代码封装成
    切面，利用AOP容器的功能将切面织入到主业务逻辑中。


#### 好处
    1. 降低耦合度，好维护
    2. 减少重复代码
    3. 专注业务代码


非业务逻辑：日志，权限校验，事务



###  AOP专业术语


###### 切面 Aspect

    切面泛指交叉业务逻辑，实际就是对主业务逻辑的一种增强。


###### 连接点 joinPoint

    连接点指可以被切面织入的具体方法，通常业务接口中的方法均可为连接点。

###### 切入点 pointCut

    切入点指声明一个或多个连接点的集合。通过切入点指定一组方法。
    
    被标记为final的方法不能作为连接点与切入点。因最终的是不能被修改的,不能被增强。


###### 目标对象 （Target）

    目标对象是指被增强的对象。


###### 通知 Advice

    通知表示切面的执行时间，Advice也叫增强。

    通知定义了增强代码切入到目标代码的时间点，是目标方
    法执行之前执行，还是之后执行等。通知类型不同，切入时间不同。


切入点定义切入的位置，通知定义切入的时间。


### AspectJ 对 AOP  的实现

AspectJ 也实现了 AOP 的功能，且其实现方式更为简捷，使用更为方便，
而且还支持注解式开发。所以，Spring 又将 AspectJ 的对于AOP 的实现也引入到了自己的框
架中。


AspectJ  基于注解的 AOP 


#### 开始运用AspectJ的项目步骤

1. 引入spring-AspectJ

        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-aspects</artifactId>
          <version>5.2.5.RELEASE</version>
        </dependency>

2. 编写切面类

        1）切面
        2）通知类型
        3）切入点
   注解@Aspect     
   
3. 将切面类交给spring容器
        
        <!--声明一个切面的bean; 单单@Aspect不能被spring识别-->
        <bean id="myAspect" class="com.ljs.aspect.MyAspect"/>
        
4. 声明自动代理生成器

        <!--声明自动代理生成器，用来生成代理-->
        <aop:aspectj-autoproxy/>


### 切入点表达式

    execution(modifiers-pattern? ret-type-pattern
    declaring-type-pattern?name-pattern(param-pattern)
    throws-pattern?)

访问修饰符 ？
返回值类型
全限定类名 ？
方法名
参数列表
抛出异常   ？

？代表是可选的，其它是必须的、

    以上表达式共 4 个部分。
    execution(访问权限 方法返回值 方法声明(参数) 异常类型)

切入点表达式要匹配的对象就是目标方法的方法名。execution 表达式中明显就
是方法的签名

    可使用通配符:
    
    * 0个或者任意多个字符
    .. 
        1）在方法参数中，标识多个参数
        2）在包名后，标识当前包及其子包
    
    + 用在类后，标识当前类及其子类
      用在接口后，标识当前接口及其实现类
  
### 通知类型

#### 前置通知 @before  

    前置通知：@Before("execution(xxx)")
    属性:value 切入点表达式,表示切面代码执行的位置(在哪个方法)
    位置:在方法的上面
    
    特点:
    1.规定了切面的执行时间,在目标方法之前.
    2.不会改变目标方法的执行结果

    @Before("execution(* *..do*(..))")
    public void beforeDo(){
        System.out.println("before do操作");
    }

#### 后置通知 @AfterReturning

    定义方法实现 后置通知的功能
          1)公共方法 public
          2)没有返回值 void
          3)方法名称自定义
          4)方法有一个参数,推荐使用Object
            也可以同时有两个参数,一个Object,一个是JoinPoint

    @AfterReturning : 后置通知
    属性: 
    1 value 切入点表达式
    2 returning 自定义的变量,表示目标方法的执行结果.
      自定义的变量名必须和通知方法的形参名一样.
    位置:在方法的定义上面
    特点:
    1.在目标方法之后执行的
    2.能够获取目标方法的执行结果.
    3.不会影响目标方法的执行



#### 环绕通知@Around


     *  在方法目标方法执行前或者后都可以做增强功能，
     *  并且能够修改目标方法的返回结果，决定执不执行目标方法。
     *
     *  增强功能方法定义：
     *
     *
     *
     *      参数: ProceedingJoinPoint
     *           ProceedingJoinPoint extends JoinPoint
     *           作用: 第一个执行目标方法 pjp.proceed()
     *                第二个,继承JoinPoint,获取方法执行时的信息
     *
     *      返回值: 就是你程序调用目标方法的最后执行结果.\
     
   
   
 
 
 
 





ProceedingJoinPoint


 JoinPoint : 连接点, 表示切面执行的位置. 就是一个业务方法.
                当执行方法时, 这个方法同时执行了切面的功能.
                这个方法的信息通过反射传给了JoinPoint, 通过这个JoinPoint
                能够获取方法执行时的信息,例如方法的名称, 方法的实际参数值.