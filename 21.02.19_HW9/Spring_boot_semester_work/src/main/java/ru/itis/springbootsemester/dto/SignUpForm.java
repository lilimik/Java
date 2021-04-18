package ru.itis.springbootsemester.dto;

import lombok.Data;

@Data
public class SignUpForm {
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String password1;
    private String password2;
}
