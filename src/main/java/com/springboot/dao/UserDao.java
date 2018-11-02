package com.springboot.dao;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserDao {

    public User getUser(User user);
}
