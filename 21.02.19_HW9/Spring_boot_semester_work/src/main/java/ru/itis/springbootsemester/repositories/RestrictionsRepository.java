package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsemester.models.Restriction;

public interface RestrictionsRepository extends JpaRepository<Restriction, Byte> {
}
