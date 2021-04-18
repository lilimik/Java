package ru.itis.springbootsemester.services;

import ru.itis.springbootsemester.dto.RestrictionDto;

import java.util.List;

public interface RestrictionsService {
    List<RestrictionDto> getAllRestrictions();
}
