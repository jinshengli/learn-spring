#### spring 事务

使用spring事务注解管理事务。


实验步骤：

    1） 建立spring和mybatis整合的实验步骤
    2） 声明事务管理器
        <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
            <property name="dataSource" ref="dataSource"/>
        </bean>
        
        声明事务管理器，需要datasource,数据源
        
    3） 开启事务注解驱动
        <tx:annotation-driven transaction-manager="transactionManager"/>
        需要事务管理器。



#### 事务的隔离级别



#### 事务的传播行为



