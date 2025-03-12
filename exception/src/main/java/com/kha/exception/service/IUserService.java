package com.kha.exception.service;

import com.kha.exception.dto.UserDto;

import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto userDto);
    UserDto findUserById(long id);
    boolean deleteUserById(long id);
    UserDto updateUser(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto findUserByEmail(String email);
}
