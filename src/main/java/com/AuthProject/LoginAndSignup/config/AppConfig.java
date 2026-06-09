package com.AuthProject.LoginAndSignup.config;

import com.AuthProject.LoginAndSignup.dto.UserResponseDto;
import com.AuthProject.LoginAndSignup.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Period;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(User.class, UserResponseDto.class)
                .setPostConverter(context -> {

                    User source = context.getSource();
                    UserResponseDto destination = context.getDestination();

                    destination.setAge(
                            Period.between(
                                    source.getBirthDate(),
                                    LocalDate.now()
                            ).getYears()
                    );

                    return destination;
                });

        return modelMapper;
    }
}