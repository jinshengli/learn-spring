package com.ljs.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Before;

/**
 * create by ljs on 2020/6/14 8:28
 * <p>
 * description:  专门做前置通知的类
 */


public class MyAspect {


    /**
     * 前置通知：@Before("execution(xxx)")
     *
     *  特点：
     *      1. 无返回类型
     *      2. 可无参数，也可以有一个参数joinPoint
     *      3. 不能影响返回结果，同时也不能查看结果。
     *
     *  作用：在目标方法执行前织入通知，就是目标方法前做增强功能。
     *
     */

    @Before("execution(* com.ljs.service.impl.SomeSerivceImpl.doSomething(String, Integer))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("这是前置通知");
        Signature signature = joinPoint.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println("declaringTypeName:" + declaringTypeName);
        Object target = joinPoint.getTarget();
        System.out.println("target" + target.getClass());
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        Object aThis = joinPoint.getThis();
        System.out.println("this: " + aThis.getClass());


    }

    @Before("execution(* *..do*(..))")
    public void beforeDo(){
        System.out.println("before do操作");
    }

    /**
     *  前置通知
     */

    @Before("execution(public void com.ljs.service.impl.MyService.learn())")
    public void beforeLearn(){
        System.out.println("学习前。。。");
    }

    @Before("execution(public void com.ljs.service.impl.SomeSerivceImpl.doWork())")
    public void beforeDoWork(){
        System.out.println("before doWork");
    }


}