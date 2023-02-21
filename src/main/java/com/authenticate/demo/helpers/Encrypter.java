package com.authenticate.demo.helpers;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encrypter {

    private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    public String genHash(String pass){
        String hashedPassword = bcrypt.encode(pass);
        return hashedPassword;
    }

    public boolean compare(String pass, String hashedPass){
        boolean isEquals =  bcrypt.matches(pass, hashedPass);
        return isEquals;
    }
}
