package ru.itis.models;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class User {
    private Long id;
    private String first_name;
    private String last_name;
    private String password;

    public User(Long id, String first_name, String last_name, String password) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }

    public User(String first_name, String last_name, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
    }
}
