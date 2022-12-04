package com.topwears.topwears.controllers;


import com.topwears.topwears.models.pojos.ApiResponse;
import com.topwears.topwears.services.PostService;
import com.topwears.topwears.utils.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/post")
public class PostController {
    private final ResponseManager responseManager;
    private final PostService postService;


    @GetMapping("/")
    public ApiResponse getAlPosts(){
        return responseManager.success(postService.getAll());
    }

    @GetMapping("/{id}")
    public  ApiResponse getAPost(@PathVariable("id") Long id){
        return responseManager.success(postService.getPost(id));
    }


}
