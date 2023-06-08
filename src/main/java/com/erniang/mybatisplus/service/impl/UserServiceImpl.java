package com.erniang.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.erniang.mybatisplus.mapper.UserMapper;
import com.erniang.mybatisplus.pojo.User;
import com.erniang.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-03 18:42
 * @Description
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUserList() {
        System.out.println(("----- selectAll ------"));
        //SELECT id,name,age,email FROM user
        //SELECT uid AS id,name AS userName,age,email,is_deleted FROM t_user WHERE is_deleted=0
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return userList;
    }

}
