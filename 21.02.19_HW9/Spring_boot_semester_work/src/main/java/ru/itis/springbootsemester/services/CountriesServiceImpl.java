package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.CountryDto;
import ru.itis.springbootsemester.repositories.CountriesRepository;

import java.util.List;

import static ru.itis.springbootsemester.dto.CountryDto.*;

@Component
public class CountriesServiceImpl implements CountriesService {

    @Autowired
    private CountriesRepository countriesRepository;

    @Override
    public List<CountryDto> getAllCountries() {
        return from(countriesRepository.findAll());
    }
}
