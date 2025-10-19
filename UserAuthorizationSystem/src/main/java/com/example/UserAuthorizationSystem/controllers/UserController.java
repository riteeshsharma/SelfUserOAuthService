package com.example.UserAuthorizationSystem.controllers;

import com.example.UserAuthorizationSystem.DTOs.*;
import com.example.UserAuthorizationSystem.models.Token;
import com.example.UserAuthorizationSystem.models.User;
import com.example.UserAuthorizationSystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto requestDto){
        Token token = userService.login(
                requestDto.getEmail(),
                requestDto.getPassword()
        );
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setToken(token);
        return new ResponseEntity<>(loginResponseDto, HttpStatus.CREATED);
    }
    @PostMapping("/signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto requestDto){
        User user = userService.signup(requestDto.getName(),requestDto.getEmail(), requestDto.getPassword());
        SignupResponseDto responseDto = new SignupResponseDto();
        responseDto.setResponseStatusDto(ResponseStatusDto.SUCCESS);
        responseDto.setUser(user);

        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
    public UserDto validateToken(ValidateTokenRequestDto requestDto){
        return null;
    }

    public LogoutResponseDto logout(LogoutRequestDto requestDto){
        return null;
    }
}
