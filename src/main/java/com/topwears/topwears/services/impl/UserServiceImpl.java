package com.topwears.topwears.services.impl;


import com.topwears.topwears.exceptions.EntityNotFoundException;
import com.topwears.topwears.exceptions.InvalidRegistrationDetailsException;
import com.topwears.topwears.models.entities.UserEntity;
import com.topwears.topwears.models.enums.Role;
import com.topwears.topwears.models.pojos.UserDto;
import com.topwears.topwears.models.pojos.UserRegistrationRequest;
import com.topwears.topwears.repositories.UserRepository;
import com.topwears.topwears.services.UserService;
import com.topwears.topwears.utils.Mapper;
import com.topwears.topwears.utils.ResponseManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final ResponseManager responseManager;
    private final UserRepository userRepository;


    @Override
    public UserDto register(UserRegistrationRequest request) {
        if(request.getName().isEmpty()) throw new InvalidRegistrationDetailsException("Name cannot be empty");
        else if (request.getPassword().isEmpty()) {
            throw new InvalidRegistrationDetailsException("Password cannot be empty");
        } else if (request.getEmail().isEmpty()) {
            throw new InvalidRegistrationDetailsException("Email cannot be empty");
        } else if (request.getGender()==null) {
            throw new InvalidRegistrationDetailsException("Gender cannot be blank");
        }

        userRepository.findByEmail(request.getEmail()).ifPresent(
                userEntity -> {throw new InvalidRegistrationDetailsException("User already exists with same email");});

        return Mapper.userToDto(userRepository.save(UserEntity.builder()
                .name(request.getName())
                .email(request.getEmail())
                .gender(request.getGender())
                .role(request.getRole())
                .build()));

    }

    @Override
    public UserDto getUser(Long id) {
        return Mapper.userToDto(userRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("User with Id: "+id+" is not in our record")));
    }
    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(Mapper::userToDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<UserDto> getUsersByRole(Role role) {
        return userRepository.findAll().stream()
                .filter(user->user.getRole()==role)
                .map(Mapper::userToDto)
                .collect(Collectors.toList());
    }
}
