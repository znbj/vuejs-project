package com.itheima.vue.controller;

import com.itheima.vue.entity.User;
import com.itheima.vue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }

    @RequestMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public String updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return "OK";
    }
}
