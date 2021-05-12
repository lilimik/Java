package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootsemester.dto.UserDto;
import ru.itis.springbootsemester.security.details.UserDetailsImpl;
import ru.itis.springbootsemester.services.UsersService;

@Controller
public class FilmsController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/films")
    public String getFilmsPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = null;
        if (userDetails != null) {
            String email = userDetails.getUsername();
            user = usersService.getUserByEmail(email);
        }
        model.addAttribute("user", user);
        return "films_page";
    }

}
