package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmsServiceImpl implements ConfirmsService {

    @Autowired
    private UsersService usersService;

    @Override
    public boolean confirmUserStateByCode(String code) {
        return usersService.confirmUserStateByCode(code);
    }

}
