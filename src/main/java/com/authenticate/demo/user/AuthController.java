package com.authenticate.demo.user;

import com.authenticate.demo.user.dto.AuthDTO;
import com.authenticate.demo.user.dto.CreateUserDTO;
import com.authenticate.demo.user.models.UserModel;
import com.authenticate.demo.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
     AuthService authService;
    @PostMapping("/signin")
    public UserModel signin(@RequestBody AuthDTO credentials){
        UserModel user = authService.auth(credentials);
        return user;
    }

    @PostMapping("/signup")
    public UserModel signup(@RequestBody CreateUserDTO user) {
            if(user.password != user.confirmPassword)
                throw new Error("Password must be equals!");
            UserModel newUser = authService.createUser(user);
            return newUser;
    }
}
