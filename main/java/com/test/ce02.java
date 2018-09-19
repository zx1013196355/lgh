package com.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//@Aspect
public class ce02 {

    //注解
//    @Around("execution(* com.test.ce01.add(..))")
//    public void add(ProceedingJoinPoint joinPoint) {
//        System.out.println("ce02");
//
//        try {
//            joinPoint.proceed(new String[]{"不是"});
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//        System.out.println("ce02");
//
//    }



    public void add(ProceedingJoinPoint joinPoint) {
        System.out.println("ce02");

        try {
            joinPoint.proceed(new String[]{"不是"});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("ce02");

    }

    public void ss() {
        System.out.println("ce022323");

    }
}
