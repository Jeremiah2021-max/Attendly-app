package com.attendly.Attendly.app.service;

import com.attendly.Attendly.app.dto.LoginRequest;
import com.attendly.Attendly.app.dto.LoginResponse;
import com.attendly.Attendly.app.model.Role;
import com.attendly.Attendly.app.model.Users;
import com.attendly.Attendly.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public String verify(Users user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken( user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated())
                return jwtService.generateToken(user.getUsername());

        return "Failed";
    }
    public LoginResponse login(LoginRequest request){
        Users user = repo.findByEmail(request.getEmail());

        if (user ==null){
            return new LoginResponse("User not found", false);
        }

        if (!user.getPassword().equals(request.getPassword())){
            return new LoginResponse("Incorrect Password", false);
        }

        return new LoginResponse("Login Successful", true);
    }
    public Users registerCourseRep(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole(Role.COURSE_REP);
        return repo.save(user);
    }
}

