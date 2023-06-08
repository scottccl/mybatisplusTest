package com.erniang.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.erniang.mybatisplus.pojo.User;

import java.util.List;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-03 18:41
 * @Description
 */
public interface UserService extends IService<User> {

    List<User> getUserList();

}
