package com.attendly.Attendly.app.controller;


import com.attendly.Attendly.app.dto.CourseRepRegisterRequest;
import com.attendly.Attendly.app.dto.LoginRequest;
import com.attendly.Attendly.app.dto.LoginResponse;
import com.attendly.Attendly.app.model.Users;
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
    public Users register(@RequestBody CourseRepRegisterRequest request){
        Users user = new Users();
        user.setUsername(request.username);
        user.setPassword(request.password);
        return userService.registerCourseRep(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return userService.login(request);
    }
}
