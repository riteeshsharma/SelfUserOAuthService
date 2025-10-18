package com.example.UserAuthorizationSystem.service;

import com.example.UserAuthorizationSystem.configurations.BcryptPasswordEncoderConfig;
import com.example.UserAuthorizationSystem.models.Token;
import com.example.UserAuthorizationSystem.models.User;
import com.example.UserAuthorizationSystem.reporitories.TokenRepository;
import com.example.UserAuthorizationSystem.reporitories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private TokenRepository tokenRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, TokenRepository tokenRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User signup(String name, String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user=null;

        if(optionalUser.isPresent()){

        }
        else{
            user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setHashedPassword(bCryptPasswordEncoder.encode(password));

            user=userRepository.save(user);
        }
        return user;
    }

    private Token createToken(User user){
        Token token = new Token();
        token.setUser(user);
        token.setValue("hjhabsbdja");

        // FIXME
        LocalDate today = LocalDate.now();
        LocalDate thirtyDaysLater = today.plus(30, ChronoUnit.DAYS);

        Date expiryAt = Date.from(thirtyDaysLater.atStartOfDay(ZoneId.systemDefault()).toInstant());

        token.setExpiryAt(expiryAt);

        return token;
    }

    @Override
    public Token login(String email, String password) {
        User user = null;
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()){
            //signup flow
        }
        else{
            user = optionalUser.get();

            if(!bCryptPasswordEncoder.matches(password, user.getHashedPassword())){
                return null;
            }

            Token token = createToken(user);
            token = tokenRepository.save(token);
            return token;
        }
        return null;
    }

    @Override
    public User validateToken(String token) {
        return null;
    }

    @Override
    public void logout(String token) {

    }
}
