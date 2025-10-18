package com.example.UserAuthorizationSystem.DTOs;

import com.example.UserAuthorizationSystem.models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
    private Token token;
}
