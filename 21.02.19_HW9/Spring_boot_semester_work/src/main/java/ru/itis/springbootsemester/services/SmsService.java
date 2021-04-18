package ru.itis.springbootsemester.services;

public interface SmsService {
    void sendSms(String phone, String text);
}
