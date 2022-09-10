package com.eshop.user.service;

import com.eshop.user.dao.UserDao;
import com.eshop.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User saveUser(User user) {
       return userDao.save(user);
    }

    @Override
    public List<User> fetchUserList() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> fetchUserById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User updateUser(User user, Integer id) {
        return null;
    }

    @Override
    public void deleteUserById(Integer id) {
         userDao.deleteById(id);
    }

    @Override
    public User fetchUserByUserName(String userName) {
        return userDao.findByUserName(userName);
    }
}
