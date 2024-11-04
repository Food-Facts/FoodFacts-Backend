package com.foodfacts.foodfacts.profiles.domain.model.queries;

import com.foodfacts.foodfacts.profiles.domain.model.valueobjects.EmailAddress;
/**
 * Get Profile By Email Query
 */
public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
