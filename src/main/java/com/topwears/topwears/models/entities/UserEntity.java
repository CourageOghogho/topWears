package com.topwears.topwears.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.topwears.topwears.models.enums.Gender;
import com.topwears.topwears.models.enums.Role;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Users")
@Table(name="users")
public class UserEntity extends BaseEntity{
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(value=EnumType.STRING)
    private Role role;


    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<PostEntity> posts;

    @JsonIgnore
    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<CommentEntity> comments;

    @JsonIgnore
    @OneToMany(
            mappedBy = "user",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<LikeEntity> likes;

    public UserEntity(String name, String email, String password, Gender gender, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
    }
}
