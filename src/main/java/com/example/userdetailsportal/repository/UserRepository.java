package com.example.userdetailsportal.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.userdetailsportal.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameIgnoreCase(String username);
}
