package com.AuthProject.LoginAndSignup.service;

import com.AuthProject.LoginAndSignup.dto.UserResponseDto;
import com.AuthProject.LoginAndSignup.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserResponseDto> getUsers() {
        
        return userRepository.findAll()
                .stream()
                .map(User -> modelMapper.map(User, UserResponseDto.class))
                .toList();
    }
}
