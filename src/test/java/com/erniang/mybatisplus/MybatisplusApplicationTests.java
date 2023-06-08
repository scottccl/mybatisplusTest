package com.erniang.mybatisplus;

import com.erniang.mybatisplus.mapper.UserMapper;
import com.erniang.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSeletctList() {
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);

    }

}
