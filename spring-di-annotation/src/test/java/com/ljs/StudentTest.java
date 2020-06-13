package com.ljs;

import com.ljs.entity.Student;
import com.ljs.service.MyService;
import com.ljs.service.impl.MyserviceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by ljs on 2020/6/13 18:53
 * <p>
 * description:
 */
public class StudentTest {

    private ClassPathXmlApplicationContext context;


    @Before
    public void setUp(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void getStudent() {
        Student bean = (Student) context.getBean("student");
        System.out.println(bean);
    }

    @Test
    public void getServiceImpl(){

        MyService myservice = (MyService) context.getBean("myServiceImpl");

        myservice.doSomthing();


    }

}
