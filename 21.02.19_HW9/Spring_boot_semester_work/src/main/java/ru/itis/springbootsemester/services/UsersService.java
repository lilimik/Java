package ru.itis.springbootsemester.services;

import ru.itis.springbootsemester.dto.UserDto;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);
}
