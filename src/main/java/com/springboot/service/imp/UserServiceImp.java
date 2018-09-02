package com.springboot.service.imp;

import com.springboot.dao.UserDao;
import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }
}
