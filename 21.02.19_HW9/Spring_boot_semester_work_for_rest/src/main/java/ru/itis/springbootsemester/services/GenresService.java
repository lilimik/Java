package ru.itis.springbootsemester.services;

import ru.itis.springbootsemester.dto.GenreDto;
import ru.itis.springbootsemester.models.Genre;

import java.util.List;

public interface GenresService {
    List<GenreDto> getAllGenres();
}
