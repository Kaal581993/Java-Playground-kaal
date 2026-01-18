package com.first_crud.api.app.service;


import com.first_crud.api.app.entity.User;
import com.first_crud.api.app.exceptions.UserNotFoundException;
import com.first_crud.api.app.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {

    private UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> searchUsers(String name, String email) {
        System.out.println(name);
        return userRepository.findAll().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name) || u.getEmail().equalsIgnoreCase(email))
                .toList();
    }

    public User createdUser(User user) {
        logger.info("Creating User...INFO");
        logger.debug("Creating User...DEBUG");
        logger.error("Creating User...ERROR");
        logger.trace("Creating User...TRACE");
        logger.warn("Creating User....WARNING");
        System.out.println(user.getEmail());

            if(user.getProfile() != null)
                user.getProfile().setUser(user);
        // Ensure it's a new user by setting id to null
            if(user.getPosts() !=null)
                user.getPosts().forEach(post -> post.setUser(user));
        user.setId(null);
        return userRepository.save(user);
    }

    public User updatedUser(User user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found with id: " + user.getId());
        }
        logger.info("Updating User");
        logger.debug("Updating User...DEBUG");
        logger.error("Updating User...ERROR");
        logger.trace("Updating User...TRACE");
        logger.warn("Updating User....WARNING");

        return userRepository.save(user);
    }

    public boolean deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User with given ID:" + id + " Not Found");
        }

        logger.info("Deleting User");
        logger.debug("Deleting User...DEBUG");
        logger.error("Deleting User...ERROR");
        logger.trace("Deleting User...TRACE");
        logger.warn("Deleting User....WARNING");
        userRepository.deleteById(id);
        return true;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NullPointerException("No users found");
        }
        logger.info("Getting User List");
        return ResponseEntity.ok(users);
    }

    public User getUserbyID(Integer id) {
        logger.info("Getting User by ID");
        System.out.println("getUserbyID called with id: " + id);
        return userRepository.findById(id).orElse(null);
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String, Object>> handleNullPointerException(Exception exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("MESSAGE", exception.getMessage());
        errorResponse.put("TIMESTAMP", LocalDateTime.now());
        errorResponse.put("STATUS", HttpStatus.BAD_REQUEST);
        errorResponse.put("ERROR", "Null Pointer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
