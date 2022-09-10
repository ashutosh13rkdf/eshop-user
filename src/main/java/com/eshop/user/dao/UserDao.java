package com.eshop.user.dao;

import com.eshop.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends JpaRepository<User, Integer> {
    User findByUserName(String userName);
}
