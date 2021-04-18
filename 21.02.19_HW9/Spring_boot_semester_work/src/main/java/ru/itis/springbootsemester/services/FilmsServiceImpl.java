package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.models.Film;
import ru.itis.springbootsemester.repositories.FilmsRepository;

import java.util.List;

@Component
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    private FilmsRepository filmsRepository;


    @Override
    public Film findById(Long id) {

    }

    @Override
    public Film findByTitle(String title) {
        return null;
    }

    @Override
    public List<Film> findFilmsByGenreName(String genreName) {
        return null;
    }

    @Override
    public List<String> findGenresByFilmTitle(String filmTitle) {
        return null;
    }

    @Override
    public List<Film> findFilmsByCountryName(String countryName) {
        return null;
    }

    @Override
    public List<String> findCountriesByFilmTitle(String filmTitle) {
        return null;
    }

    @Override
    public List<Film> findFilmsByYear(Short year) {
        return null;
    }
}
