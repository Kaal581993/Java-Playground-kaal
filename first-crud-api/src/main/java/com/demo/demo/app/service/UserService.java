package com.demo.demo.app.service;


import com.demo.demo.app.entity.User;
import com.demo.demo.app.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static Map<Integer, User> userDB = new HashMap<>();

    public static List<User> searchUsers(String name, String email) {

        System.out.println(name);
        return userDB.values().stream()
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
        userDB.putIfAbsent(user.getId(), user);
            System.out.println(user.getEmail());
            System.out.println(user.getName());
            System.out.println(user.getId());
         return user;
    }

    public User updatedUser(User user) {

        if(!userDB.containsKey(user.getId()))
            throw new IllegalArgumentException("User with given ID:"+user.getId()+" Not Found");

        logger.info("Updating User");
        logger.info("Creating User...INFO");
        logger.debug("Creating User...DEBUG");
        logger.error("Creating User...ERROR");
        logger.trace("Creating User...TRACE");
        logger.warn("Creating User....WARNING");
        userDB.put(user.getId(), user);
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        System.out.println(user.getId());

        return user;
    }

    public boolean deleteUser(int id) {

        if(!userDB.containsKey(id))
            throw new UserNotFoundException("User with given ID:"+id+" Not Found");

        logger.info("Deleting User");
        logger.info("Creating User...INFO");
        logger.debug("Creating User...DEBUG");
        logger.error("Creating User...ERROR");
        logger.trace("Creating User...TRACE");
        logger.warn("Creating User....WARNING");
        userDB.remove(id);
        return true;
    }

    public ResponseEntity<List<User>> getAllUsers() {
        if(userDB.isEmpty())
            throw new NullPointerException("No users found");
            //return ResponseEntity.noContent().build();

        logger.info("Getting User List");
        return ResponseEntity.ok(new ArrayList<>(userDB.values()));

    }

    public User getUserbyID(int id) {

        logger.info("Getting User List");
        System.out.println("getUserbyID called with id: " + id + ", userDB contains: " + userDB.keySet());
        return userDB.get(id);

    }

    public User getUserById(int id) {
        return userDB.get(id);
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<Map<String, Object>> handleNullPointerException(Exception exception){


        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("MESSAGE",exception.getMessage());
        errorResponse.put("TIMESTAMP", LocalDateTime.now());
        errorResponse.put("STATUS", HttpStatus.BAD_REQUEST);
        errorResponse.put("ERROR","Null Pointer");

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
