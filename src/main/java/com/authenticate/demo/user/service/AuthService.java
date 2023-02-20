package com.authenticate.demo.user.service;

import com.authenticate.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired()
    private UserRepository userRepository;

    public void auth(){

    }
}
