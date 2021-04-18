package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootsemester.dto.UserDto;
import ru.itis.springbootsemester.models.User;
import ru.itis.springbootsemester.security.details.UserDetailsImpl;
import ru.itis.springbootsemester.services.ConfirmsService;
import ru.itis.springbootsemester.services.UsersService;

@Controller
public class ConfirmController {

    @Autowired
    private ConfirmsService confirmsService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/confirm/{code}")
    public String getConfirmStatusPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model, @PathVariable("code") String code) {
        UserDto user = null;
        if (userDetails != null) {
            String email = userDetails.getUsername();
            user = usersService.getUserByEmail(email);
        }
        boolean confirmStatus = confirmsService.confirmUserStateByCode(code);
        model.addAttribute("user", user);
        model.addAttribute("confirmStatus", confirmStatus);
        return "confirm_status_page";
    }

}
