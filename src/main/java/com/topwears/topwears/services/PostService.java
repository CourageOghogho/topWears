package com.topwears.topwears.services;


import com.topwears.topwears.models.pojos.PostCreationRequest;
import com.topwears.topwears.models.pojos.PostDto;
import com.topwears.topwears.models.pojos.UpdateRequest;

import java.util.List;

public interface PostService {
    PostDto createPost(PostCreationRequest request);

    List<PostDto> getAll();

    PostDto getPost(Long id);

    PostDto update(UpdateRequest request);
}
