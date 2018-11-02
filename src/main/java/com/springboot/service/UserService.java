package com.springboot.service;

import com.springboot.model.User;

public interface UserService {

    /*public User getUser(User user);*/

    public User getUserByid(int id);

    public boolean insertUser(User user) throws Exception;

}
