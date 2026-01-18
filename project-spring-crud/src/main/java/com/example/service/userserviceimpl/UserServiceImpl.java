package com.example.service.userserviceimpl;

import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;
import com.example.service.UserService;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String addUser(String name) {
        userRepository.save(name);
        return "";
    }

    @Override
    public List<String> getAllUsers() {
        return userRepository.findAll();
    }
}
