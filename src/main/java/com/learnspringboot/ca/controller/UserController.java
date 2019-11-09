package com.learnspringboot.ca.controller;

import com.learnspringboot.ca.dto.CreateUserDto;
import com.learnspringboot.ca.dto.UserDto;
import com.learnspringboot.ca.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UserDto>>  getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> getOneUser(@PathVariable int id){
        return new ResponseEntity<>(userService.getOneUser(id),HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto){
        return new ResponseEntity<>(userService.createUser(createUserDto),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> updateUser(@PathVariable int id ,@RequestBody CreateUserDto createUserDto){
        return new ResponseEntity<>(userService.updateUser(id,createUserDto),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
}
