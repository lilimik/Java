package ru.itis.springbootsemester.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.springbootsemester.models.Genre;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class GenreDto {
    private Integer id;
    private String name;

    public static GenreDto from(Genre genre) {
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }

    public static List<GenreDto> from(List<Genre> genres) {
        return genres.stream().map(GenreDto::from).collect(Collectors.toList());
    }
}
