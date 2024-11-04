package com.foodfacts.foodfacts.users.application.internal.Commandservices;

import com.foodfacts.foodfacts.users.domain.model.aggregates.User;
import com.foodfacts.foodfacts.users.domain.model.commands.CreateUserCommand;
import com.foodfacts.foodfacts.users.domain.model.commands.UpdateUserCommand;
import com.foodfacts.foodfacts.users.domain.services.UserCommandService;
import com.foodfacts.foodfacts.users.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Optional<User> handle(CreateUserCommand command) {
        User user = new User();
        return Optional.of(userRepository.save(user));
    }

    @Override
    @Transactional
    public Optional<User> handle(UpdateUserCommand command) {
        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        user.updateFullName(command.firstName(), command.lastName());
        user.updateEmailAddress(command.email());
        user.updatePassword(command.password());
        return Optional.of(userRepository.save(user));
    }

    @Override
    @Transactional
    public boolean deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            return false;
        }
        userRepository.deleteById(userId);
        return true;
    }
}