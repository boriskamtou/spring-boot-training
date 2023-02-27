package com.boris.todorestapi.services.user;

import com.boris.todorestapi.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    User createUser(User user);
    Optional<User> findUserById(Long id);
    User updateUser(User user);
    void deleteUserById(Long id);
}
