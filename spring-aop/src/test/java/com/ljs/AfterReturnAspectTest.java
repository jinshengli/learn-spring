package com.ljs;

import com.ljs.service.SomeSerivce;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * create by ljs on 2020/6/14 10:54
 * <p>
 * description:
 */
public class AfterReturnAspectTest {



    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }


    @Test
    public void afterReturnDoSomething(){
        SomeSerivce someSerivce = (SomeSerivce) context.getBean("someService");
        someSerivce.doSomething("ljs", 23);
    }

    @Test
    public void afterReturnGoHome(){

        SomeSerivce someSerivce = (SomeSerivce) context.getBean("someService");
        someSerivce.goHome("广州", new Date());

    }


}
