package ru.itis.springbootsemester.services;

import ru.itis.springbootsemester.dto.UserDto;
import ru.itis.springbootsemester.dto.UserForm;

import java.util.List;

public interface UsersService {
    List<UserDto> getAllUsers();
    boolean confirmUserStateByCode(String code);
    UserDto getUserById(Long userId);
    UserDto getUserByEmail(String email);

    void updateAvatarStorageName(String email, String filePath);

    void updateUserData(UserForm form, String email);
}
