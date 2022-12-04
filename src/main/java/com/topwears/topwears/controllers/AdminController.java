package com.topwears.topwears.controllers;


import com.topwears.topwears.models.pojos.ApiResponse;
import com.topwears.topwears.models.pojos.PostCreationRequest;
import com.topwears.topwears.models.pojos.UpdateRequest;
import com.topwears.topwears.services.PostService;
import com.topwears.topwears.utils.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/admin/post")
public class AdminController {
    private final ResponseManager responseManager;
    private final PostService postService;

    @PostMapping("/")
    public ApiResponse createPost(@RequestBody PostCreationRequest request){
        return  responseManager.success(postService.createPost(request));
    }

    @PutMapping("/")
    public ApiResponse update(UpdateRequest request){
        return responseManager.success(postService.update(request));
    }
}
