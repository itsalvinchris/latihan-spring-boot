package com.learnspringboot.ca.service.impl;

import com.learnspringboot.ca.dto.CreateUserDto;
import com.learnspringboot.ca.dto.UserDto;
import com.learnspringboot.ca.model.User;
import com.learnspringboot.ca.repository.UserRepository;
import com.learnspringboot.ca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> userList = new ArrayList<>();
        userRepository.findAll().forEach(user -> {
            userList.add(new UserDto(user.getName(), user.getUsername(), user.getDateOfBirth()));
        });
        return userList;
    }

    @Override
    public UserDto getOneUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            return new UserDto(user.getName(), user.getUsername(), user.getDateOfBirth());
        }
        return null;
    }

    @Override
    public UserDto createUser(CreateUserDto createUserDto) {
        User user = new User();
        user.setName(createUserDto.getName());
        user.setDateOfBirth(createUserDto.getDateOfBirth());
        user.setUsername(createUserDto.getUsername());
        user.setPassword(createUserDto.getPassword());
        userRepository.save(user);
        return new UserDto(user.getName(), user.getUsername(), user.getDateOfBirth());
    }

    @Override
    public UserDto updateUser(Long id, CreateUserDto createUserDto) {
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            user.setName(createUserDto.getName());
            user.setDateOfBirth(createUserDto.getDateOfBirth());
            user.setUsername(createUserDto.getUsername());
            user.setPassword(createUserDto.getPassword());
            userRepository.save(user);
            return new UserDto(user.getName(), user.getUsername(), user.getDateOfBirth());
        }
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        if(userRepository.findById(id).isPresent()){
            User user = userRepository.findById(id).get();
            userRepository.delete(user);
            return "User Successfully Deleted";
        }
        return "User with id " + id + " not found";
    }
}
