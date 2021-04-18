package ru.itis.springbootsemester.services;

public interface ConfirmsService {
    boolean confirmUserStateByCode(String code);
}
