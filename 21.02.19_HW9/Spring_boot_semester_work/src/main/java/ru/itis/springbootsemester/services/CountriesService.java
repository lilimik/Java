package ru.itis.springbootsemester.services;

import ru.itis.springbootsemester.dto.CountryDto;

import java.util.List;

public interface CountriesService {
    List<CountryDto> getAllCountries();
}
