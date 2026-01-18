package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/controller/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserClassSpringBoot createUser(@RequestBody UserClassSpringBoot user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<UserClassSpringBoot> getUsers(){
        return userService.getAllUser();
    }

    @GetMapping("{id}")
    public List<UserClassSpringBoot> getUserById(int id){
        return userService.getSingleUser(id);
    }
}
