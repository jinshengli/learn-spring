package com.ljs.controller;


import com.ljs.entity.Student;
import com.ljs.service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * create by ljs on 2020/6/17 15:28
 * <p>
 * description:
 */
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

//        String config = "applicationContext.xml";
//        ApplicationContext context = new ClassPathXmlApplicationContext(config);

//        String attr = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
//        WebApplicationContext context = (WebApplicationContext) getServletContext().getAttribute(attr);

        WebApplicationContext context = WebApplicationContextUtils.findWebApplicationContext(getServletContext());

        StudentService studentService = (StudentService) context.getBean("studentService");

        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        studentService.insertStudent(student);
        System.out.println(student);


        req.getRequestDispatcher("/res.jsp").forward(req,resp);


    }
}
