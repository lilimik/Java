package ru.itis.springbootsemester.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.models.Film;

import java.util.List;
import java.util.Optional;

public interface FilmsRepository extends JpaRepository<Film, Long> {

    Optional<Film> findByTitle(String title);

    @Query(nativeQuery = true,
            value = "select f.* " +
                    "from film f " +
                    "join films_genres fg on f.id = fg.film_id " +
                    "join genre g on fg.genre_id = g.id where " +
                    "g.name = :genreName")
    List<Film> findFilmsByGenreName(String genreName);

    @Query(nativeQuery = true,
            value = "select new ru.itis.springbootsemester.dto.FilmRO(f.*,g.name genre_name, c.name country_name) " +
                    "from film f " +
                    "join films_countries fc on f.id = fc.film_id " +
                    "join country c on fc.country_id = c.id where " +
                    "c.name = :countryName")
    List<Film> findFilmsByCountryName(String countryName);

    List<Film> findFilmsByYear(Short year);

}
