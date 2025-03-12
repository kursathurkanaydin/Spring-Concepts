package com.kha.exception.controller.impl;

import com.kha.exception.controller.IUserController;
import com.kha.exception.dto.UserDto;
import com.kha.exception.service.impl.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/user")
public class UserController implements IUserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    @GetMapping("/list/id/{id}")
    public UserDto findUserById(@PathVariable(value = "id") long id) {
        return userService.findUserById(id);
    }

    @Override
    @GetMapping("/list/email/{email}")
    public UserDto findUserByEmail(@PathVariable(value = "email") String email) {
        return userService.findUserByEmail(email);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean deleteUserById(@PathVariable(value = "id") long id) {
        return userService.deleteUserById(id);
    }

    @Override
    @PostMapping("/update")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @Override
    @GetMapping("/list")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
