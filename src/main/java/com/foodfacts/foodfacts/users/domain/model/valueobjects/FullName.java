package com.foodfacts.foodfacts.users.domain.model.valueobjects;

public record FullName(String firstName, String lastName) {
    public FullName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be blank");
        }
    }
}