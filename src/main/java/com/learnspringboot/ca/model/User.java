package com.learnspringboot.ca.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
@Getter
@Setter
@ToString
public class User extends BaseModel{
    private String name;

    private String username;

    private String password;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;
}
