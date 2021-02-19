package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsemester.models.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
