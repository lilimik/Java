package ru.itis.springbootsemester.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.services.FilmsService;

import java.util.List;

@RestController
public class RestFilmsController {

    @Autowired
    private FilmsService filmsService;

    @ApiOperation(value = "Вывод всех фильмов")
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("films")
    public ResponseEntity<List<FilmRO>> getFilms() {
        return ResponseEntity.ok(filmsService.findAll());
    }

    @ApiOperation(value = "получение фильма по названию")
    @GetMapping("/films/{film-id}")
    public ResponseEntity<FilmRO> getFilmByTitle(@PathVariable("film-id") Long filmId) {
        return ResponseEntity.ok(filmsService.findFilmById(filmId));
    }

    @ApiOperation(value = "Добавление фильма")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = FilmRO.class)})
    @PostMapping("/films")
    public ResponseEntity<FilmRO> addFilm(@RequestBody FilmRO film) {
        return ResponseEntity.ok(filmsService.addFilm(film));
    }

    @ApiOperation(value = "Обновление информации о фильме")
    @PutMapping("/films/{film-id}")
    public ResponseEntity<FilmRO> updateFilm(@PathVariable("film-id") Long filmId, @RequestBody FilmRO film) {
        return ResponseEntity.ok(filmsService.updateFilm(filmId, film));
    }
}
