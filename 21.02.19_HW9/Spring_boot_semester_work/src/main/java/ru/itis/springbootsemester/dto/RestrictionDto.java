package ru.itis.springbootsemester.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.springbootsemester.models.Restriction;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RestrictionDto {
    private Byte id;

    public static RestrictionDto from(Restriction restriction) {
        return RestrictionDto.builder()
                .id(restriction.getId())
                .build();
    }

    public static List<RestrictionDto> from(List<Restriction> restrictions) {
        return restrictions.stream().map(RestrictionDto::from).collect(Collectors.toList());
    }
}
