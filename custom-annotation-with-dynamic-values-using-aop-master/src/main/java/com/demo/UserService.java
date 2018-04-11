package com.demo;


import org.springframework.stereotype.Component;

@Component
public class UserService {

    @MightMock(key = "API")
    public String getDisplayableInfo(String request) {

        System.out.println("request ->" + request);
        String response = "Original response";

        return response;
    }
}