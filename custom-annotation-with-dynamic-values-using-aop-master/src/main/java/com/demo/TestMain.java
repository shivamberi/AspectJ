package com.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean(UserService.class);
        String response = userService.getDisplayableInfo("some request");
        System.out.println(response);
    }

}