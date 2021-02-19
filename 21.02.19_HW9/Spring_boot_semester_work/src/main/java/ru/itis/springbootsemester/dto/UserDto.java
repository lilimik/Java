package ru.itis.springbootsemester.dto;

import lombok.Builder;
import lombok.Data;
import ru.itis.springbootsemester.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;

    public static UserDto from(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirst_name())
                .lastName(user.getLast_name())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
