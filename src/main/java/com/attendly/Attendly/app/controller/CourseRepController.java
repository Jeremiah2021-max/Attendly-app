package com.attendly.Attendly.app.controller;


import com.attendly.Attendly.app.dto.CourseRepRegisterRequest;
import com.attendly.Attendly.app.dto.LoginRequest;
import com.attendly.Attendly.app.dto.LoginResponse;
import com.attendly.Attendly.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course-rep")
public class CourseRepController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody CourseRepRegisterRequest request){
        return userService.registerCourseRep(request.username, request.password);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        String token = userService.login(request.username, request.password);
        LoginResponse response = new LoginResponse();
        response.token = token;
        return response;
    }
}
