package com.kha.mapper.service.impl;

import com.kha.mapper.dto.UserDto;
import com.kha.mapper.entity.User;
import com.kha.mapper.exception.UserAlreadyExistsException;
import com.kha.mapper.exception.UserNotFoundException;
import com.kha.mapper.mapper.AutoUserMapper;
import com.kha.mapper.repository.UserRepository;
import com.kha.mapper.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if (userRepository.existsUserByEmail(userDto.getEmail())){
            throw new UserAlreadyExistsException("email", userDto.getEmail());
        }
        User newUser = AutoUserMapper.MAPPER.mapToUser(userDto);
        User insertedUser = userRepository.save(newUser);
        return AutoUserMapper.MAPPER.mapToUserDto(insertedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User dbUser = userRepository.findUserByEmail(userDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("email", userDto.getEmail()));
        User newUser = AutoUserMapper.MAPPER.mapToUser(userDto);
        newUser.setId(dbUser.getId());
        User updatedUser = userRepository.save(newUser);
        return AutoUserMapper.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        User dbUser = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("email", email));
        userRepository.delete(dbUser);
        return true;
    }

    @Override
    public UserDto getUserById(int id) {
        User dbUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("id", String.valueOf(id)));
        return AutoUserMapper.MAPPER.mapToUserDto(dbUser);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User dbUser = userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException("email", email));
        return AutoUserMapper.MAPPER.mapToUserDto(dbUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(AutoUserMapper.MAPPER::mapToUserDto).toList();
    }


}
