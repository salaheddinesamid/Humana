package com.humana.humana_backend.modules.user_management.repository;

import com.humana.humana_backend.modules.user_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
