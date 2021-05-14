package ru.itis.springbootsemester.dto;

import lombok.Data;

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String password1;
    private String password2;
}
