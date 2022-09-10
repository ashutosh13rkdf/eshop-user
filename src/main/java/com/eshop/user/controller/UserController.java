package com.eshop.user.controller;

import com.eshop.user.model.User;
import com.eshop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers(){
        Optional<List<User>> users = Optional.ofNullable(userService.fetchUserList());
        if(users.isPresent()){
            return ResponseEntity.ok(users.get());
        }else{
           return (ResponseEntity<?>) ResponseEntity.noContent();
        }

    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id){
        Optional<User> user = userService.fetchUserById(id);
        if(user.isEmpty()){
            return new ResponseEntity<>("User not found!!", HttpStatus.NO_CONTENT);
        }
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else{
            return (ResponseEntity<?>) ResponseEntity.noContent();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        // Check If userName is already exist
        User userExisting = userService.fetchUserByUserName(user.getUserName());
        if(userExisting != null){
            return new ResponseEntity<>("User already exists!!", HttpStatus.OK);
        }
        User userFromDB = userService.saveUser(user);
        if(userFromDB != null){
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        // Check If user exist
        User userExisting = userService.fetchUserByUserName(user.getUserName());
        if(userExisting == null){
            return new ResponseEntity<>("User does not exists!!", HttpStatus.OK);
        }
        User userFromDB = userService.saveUser(user);
        if(userFromDB != null){
            return new ResponseEntity<>(userFromDB,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id){
        // Check If user exist
        Optional<User> userExisting = userService.fetchUserById(id);
        if(userExisting.isEmpty()){
            return new ResponseEntity<>("User does not exists!!", HttpStatus.OK);
        }
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully!!", HttpStatus.OK);

    }
}
