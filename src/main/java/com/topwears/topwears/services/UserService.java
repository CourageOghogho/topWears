package com.topwears.topwears.services;



import com.topwears.topwears.models.enums.Role;
import com.topwears.topwears.models.pojos.UserDto;
import com.topwears.topwears.models.pojos.UserRegistrationRequest;

import java.util.List;

public interface UserService {
    UserDto register(UserRegistrationRequest request);

    UserDto getUser(Long id);

    List<UserDto> getAll();

    List<UserDto> getUsersByRole(Role role);
}
