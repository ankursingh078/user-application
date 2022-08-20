package com.userapp.demo.userapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    @NotBlank(message = "User Name cannot be empty or null")
    private String name;
    @Email(message = "Email Id is not valid")
    private String emailId;
    @Pattern(regexp = "^\\d{10}", message = "Mobile number is not valid")
    private String mobileNo;
    @Min(18)
    @Max(60)
    private Integer age;
}
