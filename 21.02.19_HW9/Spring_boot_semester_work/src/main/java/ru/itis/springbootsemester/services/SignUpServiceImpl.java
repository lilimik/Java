package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.SignUpForm;
import ru.itis.springbootsemester.models.ActiveState;
import ru.itis.springbootsemester.models.ConfirmedState;
import ru.itis.springbootsemester.models.Role;
import ru.itis.springbootsemester.models.User;
import ru.itis.springbootsemester.repositories.UsersRepository;

import java.util.UUID;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private MailsService mailsService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public String signUp(SignUpForm form) {
        String password1 = form.getPassword1();
        String password2 = form.getPassword2();
        if (password1.equals(password2)) {
            User newUser = User.builder()
                    .email(form.getEmail())
                    .first_name(form.getFirstName())
                    .last_name(form.getLastName())
                    .role(Role.USER)
                    .activeState(ActiveState.ACTIVE)
                    .confirmedState(ConfirmedState.NOT_CONFIRMED)
                    .confirmCode(UUID.randomUUID().toString())
                    .hash_password(passwordEncoder.encode(password1))
                    .phone(form.getPhone())
                    .avatar_storage_name("bb83c6e4-3cf4-4396-9292-308de6c34999.png")
                    .build();

            usersRepository.save(newUser);

            mailsService.sendEmailForConfirm(newUser.getEmail(), newUser.getConfirmCode());
            smsService.sendSms(newUser.getPhone(), "Вы зарегистрированы!");
            return "redirect:/signIn";
        } else {
            return "redirect:/signUp";
        }
    }

}
