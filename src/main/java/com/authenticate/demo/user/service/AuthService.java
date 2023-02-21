package com.authenticate.demo.user.service;

import com.authenticate.demo.user.UserRepository;
import com.authenticate.demo.user.dto.AuthDTO;
import com.authenticate.demo.user.dto.CreateUserDTO;
import com.authenticate.demo.user.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired()
    UserRepository userRepository;

    public UserModel auth(AuthDTO credentials){
        UserModel user = userRepository.findByEmail(credentials.email);
        if(user == null){
            throw  new Error("User not exists");
        }
        return user;
    }

    public UserModel createUser(CreateUserDTO user){
        UserModel newUser = new UserModel(
                user.firstName,
                user.lastName,
                user.email,
                user.password);
        userRepository.save(newUser);
        return newUser;
    }
}
