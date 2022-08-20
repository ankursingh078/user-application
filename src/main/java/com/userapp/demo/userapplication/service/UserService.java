package com.userapp.demo.userapplication.service;

import com.userapp.demo.userapplication.dto.UserRequest;
import com.userapp.demo.userapplication.entity.User;
import com.userapp.demo.userapplication.exception.UserNotFoundException;
import com.userapp.demo.userapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.builder()
                .name(userRequest.getName())
                .emailId(userRequest.getEmailId())
                .mobileNo(userRequest.getMobileNo())
                .age(userRequest.getAge())
                .build();

        return userRepository.save(user);
    }

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }

    public User fetchUserById(Integer userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        return user.orElseThrow(() -> new UserNotFoundException("User not found in the Database"));
    }

    public String updateUser(UserRequest userRequest, Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userRequest.getName());
            user.setEmailId(userRequest.getEmailId());
            user.setMobileNo(userRequest.getMobileNo());
            user.setAge(userRequest.getAge());

            userRepository.save(user);
            return "User Details updated successfully";
        }
        return "User not present with Id : " + id;
    }

    public String deleteUserById(Integer userId) throws UserNotFoundException {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new UserNotFoundException("User not found in database");
        }
        return "User Deleted Successfully";
    }
}
