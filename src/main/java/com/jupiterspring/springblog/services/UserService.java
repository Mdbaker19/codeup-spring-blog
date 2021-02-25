package com.jupiterspring.springblog.services;

import com.jupiterspring.springblog.model.User;
import com.jupiterspring.springblog.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    private final UserRepository userDao;

    public UserService(UserRepository userDao){
        this.userDao = userDao;
    }

    public User loggedInUser(){
        // still hard coded but extracted now
        return userDao.findAll().get(0);
    }

    public User getOne(long l) {
        return userDao.getOne(l);
    }
}
