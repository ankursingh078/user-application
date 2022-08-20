package com.userapp.demo.userapplication.controller;

import com.userapp.demo.userapplication.dto.UserRequest;
import com.userapp.demo.userapplication.entity.User;
import com.userapp.demo.userapplication.exception.UserNotFoundException;
import com.userapp.demo.userapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest userRequest) {
        User user = userService.saveUser(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAllUsers() {
        List<User> users = userService.fetchAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Integer id) throws UserNotFoundException {
        User user = userService.fetchUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUserById(@Valid @RequestBody UserRequest userRequest,
                                                 @PathVariable("id") Integer userId) {
        String message = userService.updateUser(userRequest, userId);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) throws UserNotFoundException {
        String message = userService.deleteUserById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
