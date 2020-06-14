package com.ljs;

import com.ljs.service.SomeSerivce;
import com.ljs.service.impl.MyService;
import com.ljs.service.impl.SomeSerivceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by ljs on 2020/6/14 8:31
 * <p>
 * description:
 *      测试被切面增强的之后的对象。
 */
public class BeforeAspectTest {


    private ApplicationContext context;

    @Before
    public void setUp(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }


    @Test
    public void beforeTest(){
        SomeSerivce someSerivce = (SomeSerivce) context.getBean("someService");

        someSerivce.doSomething("ljs",23);
        /**
         * class com.sun.proxy.$Proxy17
         */
        System.out.println(someSerivce.getClass());
    }

    @Test
    public void beforeTest01(){
        /**
         * aspect 基于接口生成动态代理对象，必须转成接口类型。
         */
        SomeSerivceImpl someSerivce = (SomeSerivceImpl) context.getBean("someService");
        someSerivce.doSomething("ljs",23);
    }


    @Test
    public void beforeLearn(){
        MyService myService = (MyService) context.getBean("myService");
        myService.learn();
        myService.doWork();
        /**
         * class com.ljs.service.impl.MyService$$EnhancerBySpringCGLIB$$a37a600f
         */
        System.out.println(myService.getClass());

    }





}
