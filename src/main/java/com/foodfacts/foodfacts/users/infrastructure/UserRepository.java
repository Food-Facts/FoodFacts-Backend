package com.foodfacts.foodfacts.users.infrastructure;

import com.foodfacts.foodfacts.users.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}