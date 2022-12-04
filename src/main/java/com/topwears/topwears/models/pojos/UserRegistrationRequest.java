package com.topwears.topwears.models.pojos;

import com.topwears.topwears.models.enums.Gender;
import com.topwears.topwears.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRegistrationRequest {
    private String name;
    private String email;
    private String password;
    private Gender gender;
    private Role role;
}
