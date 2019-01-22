package com.itheima.vue.service;

import com.itheima.vue.dao.UserDao;
import com.itheima.vue.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getUserList() {
        List<User> userList = userDao.findAll();
        return userList;
    }

    public User getUserById(int id) {
        User user = userDao.findOne(id);
        return user;
    }

    public void updateUser(User user) {
        userDao.save(user);
    }
}
