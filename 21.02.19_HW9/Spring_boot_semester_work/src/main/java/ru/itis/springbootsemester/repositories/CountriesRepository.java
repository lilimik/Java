package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsemester.models.Country;

public interface CountriesRepository extends JpaRepository<Country, Integer> {
}
