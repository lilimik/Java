package ru.itis.springbootsemester.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long boxOffice;
    private Long budget;
    private String description;
    private String poster_storage_name;
    private Short year;

    @OneToMany(mappedBy = "film")
    private List<Review> reviews;

    @ManyToMany(mappedBy = "films")
    private List<Genre> genres;

    @ManyToOne
    @JoinColumn(name = "restriction")
    private Restriction restriction;

    @OneToOne(mappedBy = "film")
    @PrimaryKeyJoinColumn
    private Poster poster;

    @ManyToMany(mappedBy = "films")
    private List<Country> countries;

    @OneToMany(mappedBy = "film")
    private List<FilmCrew> filmCrew;

}
