package com.kha.exception.service.impl;

import com.kha.exception.dto.UserDto;
import com.kha.exception.entity.User;
import com.kha.exception.exception.UserAlreadyExistsException;
import com.kha.exception.exception.UserNotFoundException;
import com.kha.exception.mapper.IMapperService;
import com.kha.exception.repository.UserRepository;
import com.kha.exception.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final IMapperService<User, UserDto> toUserDto;
    private final IMapperService<UserDto, User> toUser;
    public UserService(UserRepository userRepository, IMapperService<User, UserDto> toUserDto, IMapperService<UserDto, User> toUser) {
        this.userRepository = userRepository;
        this.toUserDto = toUserDto;
        this.toUser = toUser;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> user = userRepository.findUserByEmail(userDto.getEmail());
        if (user.isPresent()){
            throw new UserAlreadyExistsException("User Already Exists");
        }
        User newUser = new User();
        BeanUtils.copyProperties(userDto, newUser);
        User insertedUser = userRepository.save(newUser);
        UserDto showInsertedUser = new UserDto();
        BeanUtils.copyProperties(insertedUser, showInsertedUser);
        return showInsertedUser;
    }

    @Override
    public UserDto findUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id", String.valueOf(id)));
        return toUserDto.map(user, UserDto.class);
    }

    @Override
    public boolean deleteUserById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("id", String.valueOf(id)));
        userRepository.delete(user);
        return true;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User dbUser = userRepository.findUserByEmail(userDto.getEmail())
                .orElseThrow(() -> new UserNotFoundException("email", userDto.getEmail()));
        dbUser.setAge(userDto.getAge());
        dbUser.setEmail(userDto.getEmail());
        dbUser.setFirstName(userDto.getFirstName());
        dbUser.setLastName(userDto.getLastName());
        User updatedUser = userRepository.save(dbUser);
        return toUserDto.map(updatedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> toUserDto.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("email", email));
        return toUserDto.map(user, UserDto.class);
    }
}
