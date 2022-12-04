package com.topwears.topwears.models.pojos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCreationRequest {
    private String title;
    private String body;
    private Long designCategoryId;
    private Long userId;
    //private MultipartFile image;

}
