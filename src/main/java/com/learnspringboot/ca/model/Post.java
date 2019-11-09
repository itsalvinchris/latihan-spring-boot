package com.learnspringboot.ca.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Post")
@Table(name = "posts")
@Getter
@Setter
@ToString
public class Post extends BaseModel{
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String messages;
}
