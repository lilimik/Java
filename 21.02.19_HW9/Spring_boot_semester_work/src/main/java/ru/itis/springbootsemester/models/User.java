package ru.itis.springbootsemester.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String hash_password;
    private String avatar_storage_name;
    private String confirmCode;
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private ActiveState activeState;

    @Enumerated(value = EnumType.STRING)
    private ConfirmedState confirmedState;

    public boolean isActive() {
        return this.activeState == ActiveState.ACTIVE;
    }

    public boolean isBanned() {
        return this.activeState == ActiveState.BANNED;
    }

    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

    public boolean isConfirmed() {
        return this.confirmedState == ConfirmedState.CONFIRMED;
    }

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

}
