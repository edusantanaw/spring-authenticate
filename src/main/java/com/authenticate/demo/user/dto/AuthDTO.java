package com.authenticate.demo.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthDTO {
    @NotBlank
    @Email
    public String email;
    @NotBlank
    @Size(min = 5, max=20)
    public  String password;
}
