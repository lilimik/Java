package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootsemester.dto.UserDto;
import ru.itis.springbootsemester.security.details.UserDetailsImpl;
import ru.itis.springbootsemester.services.UsersService;

import javax.annotation.security.PermitAll;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsersPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = null;
        if (userDetails != null) {
            String email = userDetails.getUsername();
            user = usersService.getUserByEmail(email);
        }
        model.addAttribute("user", user);
        return "users_page";
    }

    @PermitAll
    @GetMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(usersService.getUserById(userId));
    }
}
