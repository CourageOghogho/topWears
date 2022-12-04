package com.topwears.topwears.models.pojos;

import lombok.Data;

@Data
public class UpdateRequest {
    private Long postId;
    private Long userId;
    private String title;
    private String body;
    private Long designCategoryId;
}
