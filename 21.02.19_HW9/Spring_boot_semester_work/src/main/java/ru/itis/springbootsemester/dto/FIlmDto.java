package ru.itis.springbootsemester.dto;

import lombok.*;
import ru.itis.springbootsemester.models.Film;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FIlmDto {
    private Long id;
    private String title;
    private String boxOffice;
    private String budget;
    private String description;
    private Short year;
    private Byte restriction;
    private List<String> countryList;
    private List<String> genresList;

    public static FIlmDto from(Film film) {
        return FIlmDto.builder()

                .build();
    }
}
