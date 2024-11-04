package com.foodfacts.foodfacts.users.interfaces.rest;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
    // Getters and Setters
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;

}