package com.ljs.service.impl;

import com.ljs.service.SomeSerivce;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * create by ljs on 2020/6/14 8:23
 * <p>
 * description:
 */
@Service("someService")
public class SomeSerivceImpl implements SomeSerivce {

    @Override
    public void doSomething(String name, Integer age) {

        System.out.println("doSomething..............");

    }

    @Override
    public String goHome(String address, Date date) {

        String res = address + " go home at: " + date;
        System.out.println(res);
        return res;
    }

    public void doWork(){
        System.out.println("do work ...............");
    }
}
