package com.test;


import org.junit.Test;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Teststudent {
    ApplicationContext context;

    @Before
    public void BeforeStudent() {
        context = new ClassPathXmlApplicationContext("spring/huaqinlearn.xml");

    }

    @Test
    public void studentStudent() {
        ce01 ce01 = (ce01) context.getBean("ce");
        ce01.add("heheheh");
    }
}
