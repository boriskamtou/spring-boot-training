package com.boris.todorestapi.services.user;

import com.boris.todorestapi.entities.User;
import com.boris.todorestapi.repositories.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return repository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUser = repository.findById(user.getId());
        if(optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setPassword(user.getPassword());
            return updatedUser;
        } else {
            return null;
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> optionalUser = repository.findById(id);
        optionalUser.ifPresent(user -> repository.deleteById(user.getId()));
    }
}
