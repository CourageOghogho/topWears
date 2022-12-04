package com.topwears.topwears.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Post")
@Table(name = "post")
public class PostEntity extends BaseEntity{
    private String title;
    private String body;

    private Long designCategoryId;
    private String imageUri;
    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "post_user_id_fk"
            )
    )
    private UserEntity user;


    @OneToMany(
            mappedBy = "post",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<CommentEntity> comments;

    @OneToMany(
            mappedBy = "post",
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<LikeEntity> likes;

    public PostEntity(String title, String body, UserEntity user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }
}
