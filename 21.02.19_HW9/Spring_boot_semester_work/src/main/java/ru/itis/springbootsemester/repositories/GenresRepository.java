package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsemester.dto.GenreDto;
import ru.itis.springbootsemester.models.Film;
import ru.itis.springbootsemester.models.Genre;

import java.util.List;
import java.util.Optional;

public interface GenresRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByName(String name);
}