package com.userapp.demo.userapplication;

import com.userapp.demo.userapplication.entity.User;
import com.userapp.demo.userapplication.repository.UserRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "USER MANAGEMENT API",
        description = "This is User Management application", version = "1.0"))
public class UserApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        User user1 = User.builder()
                .name("Ankur")
                .age(23)
                .emailId("ankur@abc.com")
                .mobileNo("9876789876")
                .build();
        User user2 = User.builder()
                .name("Kartik")
                .age(24)
                .emailId("kartik@abc.com")
                .mobileNo("9871189876")
                .build();
        User user3 = User.builder()
                .name("Arun")
                .age(21)
                .emailId("arun@abc.com")
                .mobileNo("7776789876")
                .build();
        this.repository.save(user1);
        this.repository.save(user2);
        this.repository.save(user3);
        System.out.println("Initial Data Load Completed...");
    }
}
