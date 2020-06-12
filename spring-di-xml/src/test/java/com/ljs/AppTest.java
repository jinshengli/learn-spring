package com.ljs;



import com.ljs.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void diStudent(){


        String resource = "applicationContext.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);

        Student student = context.getBean("myStudent", Student.class);
        System.out.println(student);

        Student mystu = context.getBean("mystu", Student.class);
        System.out.println(mystu);

        mystu = context.getBean("mystu01", Student.class);
        System.out.println(mystu);
    }


    @Test
    public void autowireReference(){


        String resource = "applicationContext.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);



    }

}
