package com.AuthProject.LoginAndSignup.dto;

import com.AuthProject.LoginAndSignup.dto.type.GenderType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private GenderType gender;
    private LocalDate birthDate;
    private String city;

}
