package com.ljs.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * create by ljs on 2020/6/14 10:47
 * <p>
 * description: 专门做后置通知的切面
 *
 *   定义方法实现 后置通知的功能
 *           1)公共方法 public
 *           2)没有返回值 void
 *           3)方法名称自定义
 *           4)方法有一个参数,推荐使用Object
 *             也可以同时有两个参数,一个Object,一个是JoinPoint
 *   特点：
 *      1，在目标方法执行后执行
 *      2. 能够获取结果，但是不能改变目标方法的结果。
 *
 *
 *   @AfterReturning : 后置通知
 *           属性: 1 value 切入点表达式
 *                2 returning 自定义的变量,表示目标方法的执行结果.
 *                   自定义的变量名必须和通知方法的形参名一样.
 *
 *
 */

public class AfterReturnAspect {


    @AfterReturning(value = "execution( * *..SomeSerivceImpl.doSomething(..))")
    public void afterReturnDoSomething(){
        System.out.println("object res: ");
        System.out.println("后置通知");

    }

    @AfterReturning(value = "execution(* com..SomeSerivceImpl.goHome(..))", returning = "res")
    public void afterReturnDoGoHome(Object res){

        System.out.println("object res: "+ res);
        System.out.println("后置通知");


    }


}
