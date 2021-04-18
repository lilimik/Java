package ru.itis.springbootsemester.services;

import ru.itis.springbootsemester.dto.SignUpForm;
import ru.itis.springbootsemester.dto.UserForm;
import ru.itis.springbootsemester.models.User;

public interface SignUpService {
    String signUp(SignUpForm form);
}
