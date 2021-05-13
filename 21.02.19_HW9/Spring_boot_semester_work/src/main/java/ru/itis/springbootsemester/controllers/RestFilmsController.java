package ru.itis.springbootsemester.controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootsemester.dto.FilmRO;
import ru.itis.springbootsemester.dto.FilmsPage;
import ru.itis.springbootsemester.services.FilmsService;

@RestController
public class RestFilmsController {

    @Autowired
    private FilmsService filmsService;

    @GetMapping("/films/search")
    public ResponseEntity<FilmsPage> search(@RequestParam("size") Integer size,
                                            @RequestParam("page") Integer page,
                                            @RequestParam(value = "q", required = false) String query,
                                            @RequestParam(value = "sort", required = false) String sort,
                                            @RequestParam(value = "direction", required = false) String direction) {
        return ResponseEntity.ok(filmsService.search(size, page, query, sort, direction));
    }

    @GetMapping("/films/{film-id}")
    public ResponseEntity<FilmRO> getFilmByTitle(@PathVariable("film-id") Long filmId) {
        return ResponseEntity.ok(filmsService.findFilmById(filmId));
    }

    @ApiOperation(value = "Добавление фильма")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Успешно добавлено", response = FilmRO.class)})
    @PostMapping("/films")
    public ResponseEntity<FilmRO> addFilm(@RequestBody FilmRO film) {
        System.out.println("breakpoint");
        return ResponseEntity.ok(filmsService.addFilm(film));
    }

    @PutMapping("/films/{film-id}")
    public ResponseEntity<FilmRO> updateFilm(@PathVariable("film-id") Long filmId, @RequestBody FilmRO film) {
        return ResponseEntity.ok(filmsService.updateFilm(filmId, film));
    }
}
