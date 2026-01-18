package com.first_crud.api.app.controller;


import com.first_crud.api.app.entity.User;
import com.first_crud.api.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/controller/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User>  createUser(@RequestBody User user){

        User createdUser = userService.createdUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }



    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updatedUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

//    @GetMapping("/getusers/{id}")
//    public String getUser(@PathVariable int id){
//        String getUserData;
//        getUserData = String.valueOf(userDB.get(user.getId()));
//        return getUserData;
//    }
    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") Integer id){
        boolean isDeleted = userService.deleteUser(id);
        if(!isDeleted)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            // return ResponseEntity.ok("User Deleted");

             return ResponseEntity.noContent().build(); //-> This will give no content

    }
    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<User>  getUser(@PathVariable(value="userId", required=false) Integer id){
        System.out.println("getUser called with id: " + id);
        User user=userService.getUserbyID(id);
        System.out.println("User found: " + user);

        if(user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(user);
        }
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(
            @RequestParam(required = false, defaultValue = "KAAL") String name,
            @RequestParam(required = false, defaultValue = "kaal@kaal.com") String email

            ){

        return ResponseEntity.ok(userService.searchUsers(name,email));
    }

    @GetMapping("/info/{id}")
    public String getInfo(
            @PathVariable Integer id,
            @RequestParam(required = false, defaultValue = "defaultName") String name,
            @RequestHeader(value = "User-Agent", required = false, defaultValue = "Unknown") String userAgent){
        System.out.println("getInfo called with id: " + id + ", name: " + name + ", userAgent: " + userAgent);
        return "User Agent:" + userAgent
                +":"+id+":"+name;
    }

    @GetMapping("/{userId}/orders/{orderId}")
    public ResponseEntity<User> getUserOrder(
            @PathVariable("userId") Integer id,
            @PathVariable int orderId
    ){
        User user = userService.getUserById(id);
        if (user == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(user);
    }






}
