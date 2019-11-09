package com.learnspringboot.ca.service;

import com.learnspringboot.ca.dto.CreateUserDto;
import com.learnspringboot.ca.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getAllUser();
    public UserDto getOneUser(Long id);
    public UserDto createUser(CreateUserDto createUserDto);
    public UserDto updateUser(Long id, CreateUserDto createUserDto);
    public String deleteUser(Long id);
}
