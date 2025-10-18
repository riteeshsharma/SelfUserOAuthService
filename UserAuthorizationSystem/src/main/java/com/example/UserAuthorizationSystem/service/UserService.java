package com.example.UserAuthorizationSystem.service;

import com.example.UserAuthorizationSystem.models.Token;
import com.example.UserAuthorizationSystem.models.User;

public interface UserService {
    User signup(String name, String email, String password);
    Token login(String email, String password);
    User validateToken(String token);
    void logout(String token);

}
