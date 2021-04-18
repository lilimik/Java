package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.springbootsemester.dto.UserForm;
import ru.itis.springbootsemester.security.details.UserDetailsImpl;
import ru.itis.springbootsemester.services.UsersService;

@RequestMapping("/profile")
@Controller
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        String email = userDetails.getUsername();
        model.addAttribute("user", usersService.getUserByEmail(email));

        return "profile";
    }

//    @RequestMapping(params = "userForm")
    @PostMapping
    public String changeUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails, UserForm form) {
        String email = userDetails.getUsername();
        usersService.updateUserData(form, email);
        return "redirect:/profile";
    }
}
