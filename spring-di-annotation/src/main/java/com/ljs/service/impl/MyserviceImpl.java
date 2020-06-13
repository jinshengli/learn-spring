package com.ljs.service.impl;

import com.ljs.entity.School;
import com.ljs.service.MyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * create by ljs on 2020/6/13 18:59
 * <p>
 * description:
 */

@Service(value = "myServiceImpl")
public class MyserviceImpl implements MyService {

    @Resource(name = "school")
    private School school;

    @Override
    public void doSomthing() {

        System.out.println("doSomething");
        System.out.println("school = " + school);


    }
}
