package com.ljs.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * create by ljs on 2020/6/14 11:21
 * <p>
 * description:
 */

@Aspect
public class AroundAspect {

    /**
     *  在方法目标方法执行前或者后都可以做增强功能，
     *  并且能够修改目标方法的返回结果，决定执不执行目标方法。
     *
     *  增强功能方法定义：
     *
     *
     *
     *      参数: ProceedingJoinPoint
     *           ProceedingJoinPoint extends JoinPoint
     *           作用: 第一个执行目标方法 pjp.proceed()
     *                第二个,继承JoinPoint,获取方法执行时的信息
     *
     *      返回值: 就是你程序调用目标方法的最后执行结果.
     *
     */

    @Around(value = "execution(* com.ljs.service.impl.SomeSerivceImpl.goHome(..))")
    public Object aroundDoSomething(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around before ... ");
        Object proceed = joinPoint.proceed();  // 执行目标方法
        System.out.println("around after ... ");
        System.out.println(joinPoint.getSignature()); // 目标方法的签名
        System.out.println(joinPoint.getArgs());

        return "尼玛";
    }


}
