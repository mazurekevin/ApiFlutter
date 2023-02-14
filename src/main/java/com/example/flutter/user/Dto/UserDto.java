package com.example.flutter.user.Dto;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserDto {

    public Long id;

    @NotEmpty(message = "firstname should not be null or empty")
    public String firstname;

    @NotEmpty(message = "lastname should not be null or empty")
    public String lastname;

    @NotEmpty(message = "email should not be null or empty")
    @Email
    public String email;

    @NotEmpty(message = "password should not be null or empty")
    public String password;

    @NotEmpty
    public String languageIso = "fr";

    @NotEmpty
    public String languageName = "France";
}
