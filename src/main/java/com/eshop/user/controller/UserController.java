package com.eshop.user.controller;

import com.eshop.user.exception.UserAlreadyExistException;
import com.eshop.user.exception.UserNotFoundException;
import com.eshop.user.model.User;
import com.eshop.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> getAllUsers() {
        Optional<List<User>> users = Optional.ofNullable(userService.fetchUserList());
        return ResponseEntity.ok(users.get());

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Integer id) throws UserNotFoundException {
        log.info("get user by id");
        Optional<User> user = userService.fetchUserById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User does not exist!!");
        }
        return ResponseEntity.ok(user.get());
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) throws UserAlreadyExistException {
        // Check If userName is already exist
        User userExisting = userService.fetchUserByUserName(user.getUserName());
        if (userExisting != null) {
            throw new UserAlreadyExistException("User already exists!!");
        }
        User userFromDB = userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody User user) throws UserNotFoundException {
        // Check If user exist
        User userExisting = userService.fetchUserByUserName(user.getUserName());
        if (userExisting == null) {
            throw new UserNotFoundException("User does not exist!!");
        }
        User userFromDB = userService.saveUser(user);
        return new ResponseEntity<>(userFromDB, HttpStatus.OK);


    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Integer id) throws UserNotFoundException {
        // Check If user exist
        Optional<User> userExisting = userService.fetchUserById(id);
        if (userExisting.isEmpty()) {
            throw new UserNotFoundException("User does not exist!!");
        }
        userService.deleteUserById(id);
        return new ResponseEntity<>("User deleted successfully!!", HttpStatus.OK);

    }
}
