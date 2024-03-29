package ru.itis.springbootsemester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootsemester.dto.UserDto;
import ru.itis.springbootsemester.services.UsersService;

import javax.annotation.security.PermitAll;

@Controller
public class RestUsersController {

    @Autowired
    private UsersService usersService;

    @PermitAll
    @GetMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUserById(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(usersService.getUserById(userId));
    }
}
