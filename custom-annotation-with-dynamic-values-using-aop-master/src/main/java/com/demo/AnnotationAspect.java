package com.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AnnotationAspect {

    @Around("methodsAnnotatedWithCustomAnnotation()")
    public String processMethodsAnnotatedWithCustomAnnotation(JoinPoint joinPoint) {
        System.out.println("MightMock: Before method begins");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        MightMock customAnnotation = method.getAnnotation(MightMock.class);

        Map<String,String> store = new HashMap();
        store.put("API", "APIResponse");

        String key = customAnnotation.key();

        if(store.get(key) != null) {
            System.out.println("Key Value Fetched is:: " + key);
            return store.get(key);
        }

        return "no key present. Kindly update your database";
    }

    @Pointcut("@annotation(com.demo.MightMock)")
    private void methodsAnnotatedWithCustomAnnotation() {

    }
}
