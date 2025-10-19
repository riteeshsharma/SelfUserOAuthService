package com.example.UserAuthorizationSystem.DTOs;

import com.example.UserAuthorizationSystem.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupResponseDto {
    private ResponseStatusDto responseStatusDto;
    private User user;
}
