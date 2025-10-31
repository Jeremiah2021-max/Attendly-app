package com.attendly.Attendly.app.controller;

import com.attendly.Attendly.app.dto.LoginRequest;
import com.attendly.Attendly.app.dto.LoginResponse;

import com.attendly.Attendly.app.model.Users;
import com.attendly.Attendly.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        return service.login(request);
    }
}
