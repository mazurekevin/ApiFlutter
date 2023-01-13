package com.example.flutter.user.service;


import com.example.flutter.user.Dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getUserById(long id);
    UserDto updateUser(UserDto userDto, long id);
    void deleteUserById(long id);

    UserDto getUserByEmail(String email);
}
