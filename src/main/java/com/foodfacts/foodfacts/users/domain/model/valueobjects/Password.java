package com.foodfacts.foodfacts.users.domain.model.valueobjects;

public record Password(String value) {
    public Password {
        if (value == null || value.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }
}