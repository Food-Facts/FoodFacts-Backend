package com.foodfacts.foodfacts.users.domain.services;

import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import com.foodfacts.foodfacts.users.domain.model.queries.GetAllUsersQuery;
import com.foodfacts.foodfacts.users.domain.model.queries.GetUserByEmailQuery;
import com.foodfacts.foodfacts.users.domain.model.queries.GetUserByIdQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserQueryService {
    /**
     * Get User by ID
     *
     * @param query The {@link GetUserByIdQuery} Query
     * @return An {@link Optional} of {@link User}
     */
    Optional<User> handle(GetUserByIdQuery query);

    /**
     * Get User by Email
     *
     * @param query The {@link GetUserByEmailQuery} Query
     * @return An {@link Optional} of {@link User}
     */
    Optional<User> handle(GetUserByEmailQuery query);

    /**
     * Get All Users
     *
     * @param query The {@link GetAllUsersQuery} Query
     * @return A list of {@link User}
     */
    List<User> handle(GetAllUsersQuery query);
}