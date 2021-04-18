package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.springbootsemester.dto.SignUpForm;
import ru.itis.springbootsemester.services.SignUpService;

@RequestMapping("/signUp")
@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping
    public String signUp(SignUpForm form) {
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
