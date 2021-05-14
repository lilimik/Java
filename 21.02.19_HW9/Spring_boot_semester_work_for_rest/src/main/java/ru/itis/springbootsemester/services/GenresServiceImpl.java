package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.GenreDto;
import ru.itis.springbootsemester.repositories.GenresRepository;

import java.util.List;

import static ru.itis.springbootsemester.dto.GenreDto.*;

@Component
public class GenresServiceImpl implements GenresService {

    @Autowired
    private GenresRepository genresRepository;

    @Autowired
    private FilmsService filmsService;

    @Override
    public List<GenreDto> getAllGenres() {
        return from(genresRepository.findAll());
    }

}
