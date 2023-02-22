package com.authenticate.demo.user.service;

import com.authenticate.demo.helpers.Encrypter;
import com.authenticate.demo.user.UserRepository;
import com.authenticate.demo.user.dto.AuthDTO;
import com.authenticate.demo.user.dto.CreateUserDTO;
import com.authenticate.demo.user.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired()
    UserRepository userRepository;

    @Autowired()
    Encrypter encrypter;

    public User auth(AuthDTO credentials) {
        User user = userRepository.findByEmail(credentials.email);
        if (user == null) {
            throw new Error("User not exists");
        }
        boolean passMatch = encrypter.compare(credentials.password, user.getPass());
        if (!passMatch)
            throw new Error("Passwords must match");
        return user;
    }

    public User createUser(CreateUserDTO user) {
        User emailExists = userRepository.findByEmail(user.email);
        if (emailExists != null) {
            throw new Error("Email is already being used!");
        }
        User newUser = new User(user.username, user.email, user.password);
        newUser.setPassword(encrypter.genHash(newUser.getPass()));
        userRepository.save(newUser);
        return newUser;
    }
}
