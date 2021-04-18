package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.RestrictionDto;
import ru.itis.springbootsemester.repositories.RestrictionsRepository;

import java.util.List;

import static ru.itis.springbootsemester.dto.RestrictionDto.*;

@Component
public class RestrictionsServiceImpl implements RestrictionsService {

    @Autowired
    private RestrictionsRepository restrictionsRepository;

    @Override
    public List<RestrictionDto> getAllRestrictions() {
        return from(restrictionsRepository.findAll());
    }
}
