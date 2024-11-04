package com.foodfacts.foodfacts.users.application.internal.queryservices;

import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import com.foodfacts.foodfacts.users.domain.model.queries.GetAllUsersQuery;
import com.foodfacts.foodfacts.users.domain.model.queries.GetUserByEmailQuery;
import com.foodfacts.foodfacts.users.domain.model.queries.GetUserByIdQuery;
import com.foodfacts.foodfacts.users.domain.services.UserQueryService;
import com.foodfacts.foodfacts.users.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(GetUserByIdQuery query) {
        return userRepository.findById(query.userId());
    }

    @Override
    public Optional<User> handle(GetUserByEmailQuery query) {
        return userRepository.findByEmailAddress(query.emailAddress());
    }

    @Override
    public List<User> handle(GetAllUsersQuery query) {
        return userRepository.findAll();
    }
}