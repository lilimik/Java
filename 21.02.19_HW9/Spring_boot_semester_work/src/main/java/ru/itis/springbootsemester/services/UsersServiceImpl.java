package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.UserDto;
import static ru.itis.springbootsemester.dto.UserDto.*;
import ru.itis.springbootsemester.models.User;
import ru.itis.springbootsemester.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();
        return from(users);
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> user = usersRepository.findById(userId);
        return from(user.orElse(User.builder().build()));
    }
}
