package com.kha.exception.controller;

import com.kha.exception.dto.UserDto;

import java.util.List;

public interface IUserController {
    UserDto createUser(UserDto userDto);
    UserDto findUserById(long id);
    UserDto findUserByEmail(String email);
    boolean deleteUserById(long id);
    UserDto updateUser(UserDto userDto);
    List<UserDto> getAllUsers();
}
