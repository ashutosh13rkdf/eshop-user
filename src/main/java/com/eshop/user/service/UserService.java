package com.eshop.user.service;

import com.eshop.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // Save operation
    User saveUser(User user);

    // Read operation
    List<User> fetchUserList();

    Optional<User> fetchUserById(Integer id);

    // Update operation
    User updateUser(User user, Integer id);

    // Delete operation
    void deleteUserById(Integer id);

    User fetchUserByUserName(String userName);
}
