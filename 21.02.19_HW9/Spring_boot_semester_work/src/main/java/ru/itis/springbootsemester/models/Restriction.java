package ru.itis.springbootsemester.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Restriction {
    @Id
    @Column(name = "age")
    private Byte id;

    @OneToMany(mappedBy = "restriction")
    private List<Film> films;
}
