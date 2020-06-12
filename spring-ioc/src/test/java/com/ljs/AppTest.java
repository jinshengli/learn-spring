package com.ljs;

import static org.junit.Assert.assertTrue;

import com.ljs.service.MyService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void SpringTest() {

        String config = "beans.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);

        MyService myService = (MyService) context.getBean("myservice");
        myService.doSomething();



    }




}
