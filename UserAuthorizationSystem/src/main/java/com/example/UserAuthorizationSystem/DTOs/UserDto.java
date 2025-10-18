package com.example.UserAuthorizationSystem.DTOs;

import com.example.UserAuthorizationSystem.models.Roles;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private  String email;
    private List<Roles> role;
}
