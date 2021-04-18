package ru.itis.springbootsemester.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.springbootsemester.models.Country;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CountryDto {
    private Integer id;
    private String name;

    public static CountryDto from(Country country) {
        return CountryDto.builder()
                .id(country.getId())
                .name(country.getName())
                .build();
    }

    public static List<CountryDto> from(List<Country> countries) {
        return countries.stream().map(CountryDto::from).collect(Collectors.toList());
    }
}
