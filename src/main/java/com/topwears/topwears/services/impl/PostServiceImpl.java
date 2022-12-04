package com.topwears.topwears.services.impl;


import com.topwears.topwears.exceptions.EntityNotFoundException;
import com.topwears.topwears.exceptions.InvalidRegistrationDetailsException;
import com.topwears.topwears.models.entities.PostEntity;
import com.topwears.topwears.models.entities.UserEntity;
import com.topwears.topwears.models.enums.Role;
import com.topwears.topwears.models.pojos.PostCreationRequest;
import com.topwears.topwears.models.pojos.PostDto;
import com.topwears.topwears.models.pojos.UpdateRequest;
import com.topwears.topwears.repositories.DesignRepository;
import com.topwears.topwears.repositories.PostRepository;
import com.topwears.topwears.repositories.UserRepository;
import com.topwears.topwears.services.PostService;
import com.topwears.topwears.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final DesignRepository designRepository;
    //private final BASE_IMAGE_PATH
    @Override
    public PostDto createPost(PostCreationRequest request) {

        UserEntity user = getUserEntity(request.getTitle(), request.getBody(), request.getUserId());
        return Mapper.postToDto(postRepository.save(PostEntity.builder()
                .title(request.getTitle())
                .body(request.getBody())
                .user(user)
                .designCategoryId(request.getDesignCategoryId())
                //.imageUri(request.getImage().getOriginalFilename())
                .build()));
    }


    @Override
    public List<PostDto> getAll() {
        return postRepository.findAll().stream()
                .map(Mapper::postToDto)
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPost(Long id) {
        return Mapper.postToDto(postRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Post with id: "+id+" not found")
        ));
    }

    @Override
    public PostDto update(UpdateRequest request) {
        UserEntity user = getUserEntity(request.getTitle(), request.getBody(), request.getUserId());
        if (user.getRole()!= Role.ADMIN) throw  new InvalidRegistrationDetailsException("You are not Authorized to make a post");
        if(!designRepository.existsById(request.getDesignCategoryId())) throw new InvalidRegistrationDetailsException("Design Category not found");

        PostEntity post =postRepository.findById(request.getPostId()).orElseThrow(
                ()->  new InvalidRegistrationDetailsException("User not known"));
        post.setBody(request.getBody());
        post.setTitle(request.getTitle());
        post.setDesignCategoryId(request.getDesignCategoryId());

        return Mapper.postToDto(postRepository.saveAndFlush(post));
    }


    private UserEntity getUserEntity(String title, String body, Long userId) {
        UserEntity user;
        if(title.isEmpty() || body.isEmpty())
            throw new InvalidRegistrationDetailsException("Title or Text body cannot be empty");
        else  {
            user=userRepository.findById(userId).orElseThrow(
                    ()->  new InvalidRegistrationDetailsException("User not known"));
        }
        if(user.getRole()!= Role.ADMIN){
            throw  new InvalidRegistrationDetailsException("You are not Authorized to make a post");
        }
        return user;
    }
}
