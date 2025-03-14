package com.kha.mapper.controller.impl;

import com.kha.mapper.controller.IUserController;
import com.kha.mapper.dto.UserDto;
import com.kha.mapper.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/user")
public class UserControllerImpl implements IUserController {
    private final IUserService userService;

    public UserControllerImpl(IUserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @Override
    @PostMapping("/update")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }

    @Override
    @DeleteMapping("/delete/{email}")
    public boolean deleteUserByEmail(@PathVariable(value = "email") String email) {
        return userService.deleteUserByEmail(email);
    }

    @Override
    @GetMapping("/list/{id}")
    public UserDto getUserById(@PathVariable int id) {

        return userService.getUserById(id);
    }

    @Override
    @GetMapping("/list/{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @Override
    @GetMapping("/list")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }


}
