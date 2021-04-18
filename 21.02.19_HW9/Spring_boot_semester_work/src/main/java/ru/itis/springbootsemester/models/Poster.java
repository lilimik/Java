package ru.itis.springbootsemester.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Poster {
    @Id
    @Column(name = "film_id")
    private Long id;
    private String storageName;
    private String originalName;
    private String type;
    private Long size;
    private String url;

    @OneToOne
    @MapsId
    @JoinColumn(name = "film_id")
    private Film film;

}
