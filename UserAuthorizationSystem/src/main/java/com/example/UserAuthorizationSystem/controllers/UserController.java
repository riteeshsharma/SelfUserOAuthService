package com.example.UserAuthorizationSystem.controllers;

import com.example.UserAuthorizationSystem.DTOs.*;
import com.example.UserAuthorizationSystem.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public LoginResponseDto login(LoginRequestDto requestDto){
        return null;
    }

    public SignupResponseDto signup(SignupRequestDto requestDto){
        return null;
    }
    public UserDto validateToken(ValidateTokenRequestDto requestDto){
        return null;
    }

    public LogoutResponseDto logout(LogoutRequestDto requestDto){
        return null;
    }
}
