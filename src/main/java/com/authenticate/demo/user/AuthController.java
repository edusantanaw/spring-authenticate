package com.authenticate.demo.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/auth")
public class AuthController {

    @PostMapping("/signin")
    public void signin(){

    }
}
