package ru.itis.springbootsemester.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int born;

    @ManyToOne
    @JoinColumn(name = "contry_id")
    private Country country;

    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    @OneToMany(mappedBy = "person")
    private List<FilmCrew> filmCrew;
}
