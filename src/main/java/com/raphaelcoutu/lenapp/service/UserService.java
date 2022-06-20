package com.raphaelcoutu.lenapp.service;

import com.raphaelcoutu.lenapp.entity.User;
import com.raphaelcoutu.lenapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getBySubject(UUID subject) {
        return userRepository.findById(subject).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
