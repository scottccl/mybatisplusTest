package com.erniang.mybatisplus;

import com.erniang.mybatisplus.pojo.User;
import com.erniang.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-03 18:44
 * @Description
 */

@SpringBootTest
public class MybatisplusServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testServiceCount(){
        //SELECT COUNT( * ) FROM user
        long count = userService.count();
        System.out.println("### count =" + count);
    }

    @Test
    public void testServiceInsert(){
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        List<User> list = new ArrayList<>();
        for (int i=0;i<10; i++){
            User user = new User();
            user.setUserName("ybc" +i);
            user.setAge(20+i);
            user.setEmail("erniang@qq.com");
            list.add(user);
        }
        boolean flag = userService.saveBatch(list);
        System.out.println("### flag =" + flag);
    }

}
