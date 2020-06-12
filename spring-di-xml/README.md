## spring 基于xml的注入

    通过xml的方式定义bean对象，和给对象赋值。


主要的语法说明, 对象属性赋值


####一 setter 注入方式

1. 简单类型 

        <property name="age" value="23"/>
    
2. 引用类型

        <property name="school" ref="youSchool"/>
     
setter注入案例：
     
    <bean id="myStudent" class="com.ljs.entity.Student">
       <property name="name" value="ljs"/>
       <property name="age" value="23"/>
       <property name="school" ref="school"/>
    </bean>


####二 构造器注入

1. 使用construct-arg 的name属性；

        <construct-arg name="xxx" value="xxx"/>
2. 使用construct-arg 的index属性；指明参数的顺序

        <construct-arg index="0" value="xxx"/>

构造器注入 的例子【bean的定义，赋值】

    <bean id="mystu" class="com.ljs.entity.Student">
       <constructor-arg name="name" value="shmma"/>
       <constructor-arg name="age" value="100"/>
       <property name="school" ref="school"/>
    </bean>

    <bean id="mystu01" class="com.ljs.entity.Student">
        <constructor-arg index="0" value="gaung"/>
        <constructor-arg index="1" value="21"/>
        <property name="school" ref="school"></property>
    </bean>

    <bean id="school" class="com.ljs.entity.School">
       <property name="name" value="华南理工大学"/>
       <property name="address" value="广东广州"/>
    </bean>
    
 ####三 属性中为引用类型的自动注入
 
 ##### 1 byName的自动注入
 
 属性名要和spring容器中的bean的id，类型是同源。
 
    <bean id="stu03" class="com.ljs.entity.Student" autowire="byType">
         <property name="name" value="拉下"/>
         <property name="age" value="32"/>
     </bean>
     
 
 ##### 2 byType的自动类型注入
 
 被注入的属性类型要和注入的是同源类型、
 
     <bean id="stu03" class="com.ljs.entity.Student" autowire="byType">
         <property name="name" value="拉下"/>
         <property name="age" value="32"/>
     </bean>

 
 
 #### 为应用指定多个配置文件
 
 applicationContext.xml 是主配置文件用于
 引入多个配置文件。
 
 1）
 
 
    <import resource="classpath:bean/spring-school.xml"/>
    <import resource="classpath:bean/spring-student.xml"/>
    
 2) 使用通配符 *； 代表任意字符、
 
    主配置文件不要和其他配置文件在同一文件夹，好像不好使、【针对*】
    
    
        <import resource="classpath:bean/spring*.xml"/>
     