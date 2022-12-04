package com.topwears.topwears.utils;


import com.topwears.topwears.models.entities.PostEntity;
import com.topwears.topwears.models.entities.UserEntity;
import com.topwears.topwears.models.pojos.PostDto;
import com.topwears.topwears.models.pojos.UserDto;

public class Mapper {
    public static UserDto userToDto(UserEntity user) {
        return UserDto.builder()
                .name(user.getName())
                .name(user.getName())
                .id(user.getId())
                .gender(user.getGender())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }


    public static PostDto postToDto(PostEntity post){
        return PostDto.builder()
                .id(post.getId())
                .userId(post.getUser().getId())
                .title(post.getTitle())
                .body(post.getBody())
                .designCategoryId(post.getDesignCategoryId())
                //.imageUri(post.getImageUri())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .comments(post.getComments())
                .likes(post.getLikes())
                .build();
    }
}
