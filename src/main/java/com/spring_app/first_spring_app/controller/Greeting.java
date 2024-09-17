package com.spring_app.first_spring_app.controller;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class Greeting {

    @GetMapping("/")
    public String postMethodName(HttpServletRequest request) {
        return "Hello Guys, Welcome to my page :)<br>Current Session ID:" +
                request.getSession().getId();
    }

}