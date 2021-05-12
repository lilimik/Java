package ru.itis.springbootsemester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.models.Country;
import ru.itis.springbootsemester.models.Film;
import ru.itis.springbootsemester.models.Genre;
import ru.itis.springbootsemester.repositories.FilmsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.itis.springbootsemester.dto.FilmRO.*;

@Component
public class FilmsServiceImpl implements FilmsService {

    @Autowired
    private FilmsRepository filmsRepository;

    @Override
    public FilmRO findFilmById(Long id) {
        Optional<Film> film = filmsRepository.findById(id);
        return from(film.orElse(Film.builder().build()));
    }

    @Override
    public FilmRO findFilmByTitle(String title) {
        Optional<Film> film = filmsRepository.findByTitle(title);
        return from(film.orElse(Film.builder().build()));
    }

    @Override
    public List<FilmRO> findFilmsByGenreName(String genreName) {
        return from(filmsRepository.findFilmsByGenreName(genreName));
    }

    @Override
    public List<FilmRO> findFilmsByCountryName(String countryName) {
        return from(filmsRepository.findFilmsByCountryName(countryName));
    }

    @Override
    public List<FilmRO> findFilmsByYear(Short year) {
        return from(filmsRepository.findFilmsByYear(year));
    }

    @Override
    public FilmRO addFilm(FilmRO film) {
        Film newFilm = Film.builder()
                .title(film.getTitle())
                .boxOffice(film.getBoxOffice())
                .budget(film.getBudget())
                .description(film.getDescription())
                .poster_storage_name(film.getPoster_storage_name())
                .year(film.getYear())
                .build();

        filmsRepository.save(newFilm);
        return from(newFilm);
    }

    @Override
    public FilmRO updateFilm(Long filmId, FilmRO film) {
        Film filmForUpdate = filmsRepository.findById(filmId).orElseThrow(IllegalAccessError::new);
        String title = film.getTitle();
        Long boxOffice = film.getBoxOffice();
        Long budget = film.getBudget();
        String description = film.getDescription();
        Short year = film.getYear();
        if (!title.isEmpty()) {
            filmForUpdate.setTitle(title);
        }
        if (boxOffice != null) {
            filmForUpdate.setBoxOffice(boxOffice);
        }
        if (budget != null) {
            filmForUpdate.setBudget(budget);
        }
        if (!description.isEmpty()) {
            filmForUpdate.setDescription(description);
        }
        if (year != null) {
            filmForUpdate.setYear(year);
        }

        filmsRepository.save(filmForUpdate);
        return from(filmForUpdate);
    }
}
