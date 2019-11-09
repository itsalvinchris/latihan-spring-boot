package com.learnspringboot.ca.service;

import com.learnspringboot.ca.dto.CreateUserDto;
import com.learnspringboot.ca.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUser();
    public UserDto getOneUser(int id);
    public UserDto createUser(CreateUserDto createUserDto);
    public UserDto updateUser(int id, CreateUserDto createUserDto);
    public String deleteUser(int id);
}
