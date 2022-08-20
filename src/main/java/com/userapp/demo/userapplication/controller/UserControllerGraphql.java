package com.userapp.demo.userapplication.controller;

import com.userapp.demo.userapplication.dto.UserRequest;
import com.userapp.demo.userapplication.entity.User;
import com.userapp.demo.userapplication.exception.UserNotFoundException;
import com.userapp.demo.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserControllerGraphql {

    @Autowired
    private UserService userService;

    @MutationMapping("createUser")
    public User saveUser(@Valid @Argument UserRequest userRequest) {
        return this.userService.saveUser(userRequest);
    }

    @QueryMapping("allUsers")
    public List<User> findAllUsers() {
        return this.userService.fetchAllUsers();
    }

    @QueryMapping("getUser")
    public User findUserById(@Argument Integer id) throws UserNotFoundException {
        return this.userService.fetchUserById(id);
    }
}
