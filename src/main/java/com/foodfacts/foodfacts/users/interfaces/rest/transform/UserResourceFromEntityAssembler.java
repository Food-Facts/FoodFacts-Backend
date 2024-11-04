package com.foodfacts.foodfacts.users.interfaces.rest.transform;

import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import com.foodfacts.foodfacts.users.interfaces.rest.resources.UserResource;

/**
 * Assembler to convert a User entity to a UserResource.
 */
public class UserResourceFromEntityAssembler {
    /**
     * Converts a User entity to a UserResource.
     * @param entity The {@link User} entity to convert.
     * @return The {@link UserResource} resource.
     */
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(
                entity.getId(),
                entity.getFullName().split(" ")[0], // Extract first name
                entity.getFullName().split(" ")[1], // Extract last name
                entity.getEmailAddress(),
                entity.getPassword().value(),
                entity.getDateOfBirth());
    }
}