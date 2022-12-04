package com.topwears.topwears.models.pojos;


import com.topwears.topwears.models.entities.CommentEntity;
import com.topwears.topwears.models.entities.LikeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;
    private Long userId;
    private Long designCategoryId;
    private String title;
    private String body;
    //private String imageUri;
    private Date createdAt;
    private LocalDateTime updatedAt;
    private List<CommentEntity> comments;
    private List<LikeEntity> likes;
}
