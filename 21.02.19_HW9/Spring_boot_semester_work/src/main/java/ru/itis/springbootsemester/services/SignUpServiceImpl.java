package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.UserForm;
import ru.itis.springbootsemester.models.User;
import ru.itis.springbootsemester.repositories.UsersRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm form) {
        User newUser = User.builder()
                .email(form.getEmail())
                .first_name(form.getFirstName())
                .last_name(form.getLastName())
                .hash_password(passwordEncoder.encode(form.getPassword()))
                .build();

        usersRepository.save(newUser);
    }

}
