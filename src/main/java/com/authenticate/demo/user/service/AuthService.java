package com.authenticate.demo.user.service;

import com.authenticate.demo.user.UserRepository;
import com.authenticate.demo.user.dto.AuthDTO;
import com.authenticate.demo.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired()
    private UserRepository userRepository;

    public User auth(AuthDTO credentials){
        User user = userRepository.findByEmail(credentials.email);
        if(user == null){
            throw  new Error("User not exists");
        }
        return user;
    }

    public User createUser(){

        return new User();
    }
}
