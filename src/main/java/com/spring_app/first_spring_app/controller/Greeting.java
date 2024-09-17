package com.spring_app.first_spring_app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.spring_app.first_spring_app.model.Users;
import com.spring_app.first_spring_app.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Greeting {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String postMethodName(HttpServletRequest request) {
        return "Hello Guys, Welcome to my page :)<br>Current Session ID:" +
        request.getSession().getId();
    }

    @PostMapping("/register")
    public Users regiterUser(@RequestBody Users user) {
        return userService.register(user);
    }

    
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
