package com.attendly.Attendly.app.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Hello, Welcome to your beginning! Evelyn and Jeremiah" + request.getSession().getId();
    }
}
