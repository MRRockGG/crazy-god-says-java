package com.lin.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式3：使用注解方式实现AOP
@Aspect//标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.lin.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("===方法执行qian===");
    }
    @After("execution(* com.lin.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("===方法执行hou===");
    }

    //在环绕增强中，我们可以定义一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.lin.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("===环绕前===");

        Signature signature = jp.getSignature();//获得签名
        System.out.println("signature"+signature);

        //执行方法
        Object proceed = jp.proceed();

        System.out.println("===环绕后===");

        System.out.println(proceed);
    }
}
