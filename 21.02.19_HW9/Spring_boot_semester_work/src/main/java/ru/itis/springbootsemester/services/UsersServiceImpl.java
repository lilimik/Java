package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.UserDto;

import static ru.itis.springbootsemester.dto.UserDto.*;

import ru.itis.springbootsemester.dto.UserForm;
import ru.itis.springbootsemester.models.ConfirmedState;
import ru.itis.springbootsemester.models.User;
import ru.itis.springbootsemester.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Override
    public UserDto getUserByEmail(String email) {
        return from(usersRepository.findFirstByEmail(email));
    }

    @Override
    public void updateAvatarStorageName(String email, String filePath) {
        User user = usersRepository.findFirstByEmail(email);
        user.setAvatar_storage_name(filePath);
        usersRepository.save(user);
    }

    @Override
    public void updateUserData(UserForm form, String email) {
        User user = usersRepository.findFirstByEmail(email);

        String password = form.getPassword1();
        String firstName = form.getFirstName();
        String lastName = form.getLastName();

        if (!firstName.isEmpty()) {
            user.setLast_name(lastName);
        }
        if (!lastName.isEmpty()) {
            user.setFirst_name(firstName);
        }
        if (!password.isEmpty()
                && password.equals(form.getPassword2())
                && password.length() >= 6) {
            user.setHash_password(passwordEncoder.encode(password));
        }
        usersRepository.save(user);

    }

    public boolean confirmUserStateByCode(String code) {
        boolean confirmStatus = false;
        Optional<User> optionalUser = usersRepository.findByConfirmCode(code);
        User user = optionalUser.orElse(null);
        if (optionalUser.isPresent() && user.getConfirmedState() == ConfirmedState.NOT_CONFIRMED) {
            user.setConfirmedState(ConfirmedState.CONFIRMED);
            usersRepository.save(user);
            confirmStatus = true;
        }
        return confirmStatus;
    }

}
