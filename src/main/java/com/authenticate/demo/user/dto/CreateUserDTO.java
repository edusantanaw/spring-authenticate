package com.authenticate.demo.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserDTO {
    @NotBlank
    @Size(min = 3, max = 15)
    public String username;
    @NotBlank
    @Email
    public String email;


    @NotBlank
    @Size(min = 5, max=20)
    public String password;

    @NotBlank
    @Size(min = 5, max=20)
    public String confirmPassword;
}
