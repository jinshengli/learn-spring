package com.ljs;

import com.ljs.dao.StudentDao;
import com.ljs.entity.Student;
import com.ljs.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by ljs on 2020/6/15 16:05
 * <p>
 * description:  测试 spring 容器中的bean。
 */
public class StudentSerivceTest {

    private ClassPathXmlApplicationContext context;

    @Before
    public void init(){
        String config = "applicationContext.xml";
        context = new ClassPathXmlApplicationContext(config);
    }

    @Test
    public void allBeanInIOC(){

        String[] definitionNames = context.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }

    }

    @Test
    public void getProxyDao(){

        StudentDao dao = (StudentDao) context.getBean("studentDao");
        /**
         * org.apache.ibatis.binding.MapperProxy@291b4bf5;
         *
         * mybatis基于dao接口生成的动态代理对象。
         *
         */
        System.out.println(dao);
    }

    @Test
    public void getServiceBean(){

        StudentService studentService = (StudentService) context.getBean("studentService");

        Student student = new Student();
        student.setName("新馆");
        student.setAge(23);
        System.out.println(studentService);

       studentService.insertStudent(student);

    }






}
