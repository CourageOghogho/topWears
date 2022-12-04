package com.topwears.topwears.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Comment")
@Table(name = "comment")
public class CommentEntity extends BaseEntity{
    private  String body;
    @ManyToOne(targetEntity = PostEntity.class)
    @JoinColumn(
            name = "post_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "comment_post_id_fk"
            )
    )
    private PostEntity post;

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "comment_user_id_fk"
            )
    )
    private UserEntity user;

}
