package com.erniang.mybatisplus.controller;

import com.erniang.mybatisplus.pojo.User;
import com.erniang.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-29 16:38
 * @Description
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<User> getUserList(){
        System.out.println("##### call getUserList...");
        return userService.getUserList();
    }

}
