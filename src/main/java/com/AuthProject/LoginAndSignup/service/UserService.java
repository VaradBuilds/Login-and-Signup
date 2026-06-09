package com.AuthProject.LoginAndSignup.service;

import com.AuthProject.LoginAndSignup.dto.UserRequestDto;
import com.AuthProject.LoginAndSignup.dto.UserResponseDto;
import com.AuthProject.LoginAndSignup.entity.User;
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
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .toList();
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {
//        if (userRepository.existsById(userRequestDto.getId())) {
//            throw new IllegalArgumentException("User already exists.");
//        }
        
        User user = modelMapper.map(userRequestDto, User.class);
        return modelMapper.map(userRepository.save(user), UserResponseDto.class);
    }
}
