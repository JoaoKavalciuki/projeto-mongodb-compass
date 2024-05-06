package com.mongoproject.compassmongo.controllers;

import com.mongoproject.compassmongo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public List<User> findAll(){
        User charles = new User("Charles", "charles1@gmail.com");
        User mary = new User("Maria", "mary@gmail.com");
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(charles, mary));
        return users;
    }
}
