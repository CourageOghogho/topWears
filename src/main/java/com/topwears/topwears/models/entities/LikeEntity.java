package com.topwears.topwears.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Likes")
@Table(name = "likes")
public class LikeEntity<T> extends BaseEntity{

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "like_user_id_fk"
            )
    )
    private UserEntity user;

    @ManyToOne(targetEntity = PostEntity.class)
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "like_post_id_fk"
            )
    )
    private PostEntity post;

}
