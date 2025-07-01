package com.task.service;

import com.task.model.User;
import com.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class UserService {

    private final UserRepository userRepository;

    // ✅ Constructor Injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public java.util.List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }
}
