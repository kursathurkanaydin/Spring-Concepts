package com.kha.mapper.controller;

import com.kha.mapper.dto.UserDto;

import java.util.List;

public interface IUserController {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    boolean deleteUserByEmail(String email);
    UserDto getUserById(int id);
    UserDto getUserByEmail(String email);
    List<UserDto> getAllUsers();
}
