
package com.example.userdetailsportal.service;

import org.springframework.stereotype.Service;
import com.example.userdetailsportal.dto.UserResponse;
import com.example.userdetailsportal.model.User;
import com.example.userdetailsportal.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                    new UserNotFoundException("User not found for ID: " + id));

        return toResponse(user);
    }

    public UserResponse getByUsername(String username) {
        User user = userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(() ->
                    new UserNotFoundException("User not found for username: " + username));

        return toResponse(user);
    }

    private UserResponse toResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getUsername(),
                user.getEmail(),
                user.getMobileNumber(),
                user.getAge(),
                user.getCity(),
                user.getState()
        );
    }
}
