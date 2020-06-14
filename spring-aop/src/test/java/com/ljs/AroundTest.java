package com.ljs;

import com.ljs.service.SomeSerivce;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * create by ljs on 2020/6/14 11:35
 * <p>
 * description:
 */
public class AroundTest {


    private ApplicationContext context;

    @Before
    public void setUp() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }


    @Test
    public void aroundDowork(){

        SomeSerivce someSerivce = (SomeSerivce) context.getBean("someService");
        String wwo = someSerivce.goHome("wwo", new Date());
        System.out.println(wwo);

    }

}
