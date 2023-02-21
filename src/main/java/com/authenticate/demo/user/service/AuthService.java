package com.authenticate.demo.user.service;

import com.authenticate.demo.helpers.Encrypter;
import com.authenticate.demo.user.UserRepository;
import com.authenticate.demo.user.dto.AuthDTO;
import com.authenticate.demo.user.dto.CreateUserDTO;
import com.authenticate.demo.user.models.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired()
    UserRepository userRepository;

    @Autowired()
    Encrypter encrypter;

    public UserModel auth(AuthDTO credentials){
        UserModel user = userRepository.findByEmail(credentials.email);
        if(user == null){
            throw  new Error("User not exists");
        }
        boolean passMatch = encrypter.compare(credentials.password, user.getPass());
        if(!passMatch) throw  new Error("Passwords not match");
        return user;
    }

    public UserModel createUser(CreateUserDTO user){
        UserModel emailExists = userRepository.findByEmail(user.email);
        if(emailExists != null) {
            throw  new Error("Email is already being used!");
        }
        UserModel newUser = new UserModel(user.firstName,
                user.lastName, user.email, user.password);
        newUser.setPassword(encrypter.genHash(newUser.getPass()));
        userRepository.save(newUser);
        return newUser;
    }
}
