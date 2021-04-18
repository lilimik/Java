package ru.itis.springbootsemester.services;

public interface MailsService {
    void sendEmailForConfirm(String email, String code);
}
