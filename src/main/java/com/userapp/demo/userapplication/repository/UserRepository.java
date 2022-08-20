package com.userapp.demo.userapplication.repository;

import com.userapp.demo.userapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
