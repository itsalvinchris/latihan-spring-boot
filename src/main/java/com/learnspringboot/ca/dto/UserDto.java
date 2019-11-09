package com.learnspringboot.ca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String name;
    private String username;
    private Date dateOfBirth;
}
