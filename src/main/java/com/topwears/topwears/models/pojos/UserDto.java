package com.topwears.topwears.models.pojos;

import com.topwears.topwears.models.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private Date createdAt;
    private LocalDateTime updatedAt;
    private String name;
    private String email;
    private Gender gender;

}
