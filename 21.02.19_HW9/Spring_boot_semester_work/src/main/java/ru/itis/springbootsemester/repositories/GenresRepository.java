package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsemester.models.Genre;

public interface GenresRepository extends JpaRepository<Genre, Integer> {
}
