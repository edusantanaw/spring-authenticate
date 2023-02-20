package com.authenticate.demo.user;

import com.authenticate.demo.user.dto.AuthDTO;
import com.authenticate.demo.user.entity.User;
import com.authenticate.demo.user.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authSerce;
    @PostMapping("/signin")
    public User signin(@RequestBody AuthDTO credentials){
        User user = authSerce.auth(credentials);
        return user;
    }
}
