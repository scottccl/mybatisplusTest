package com.erniang.mybatisplus;

import com.erniang.mybatisplus.enums.SexEnum;
import com.erniang.mybatisplus.mapper.UserMapper;
import com.erniang.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-04 22:34
 * @Description
 */
@SpringBootTest
public class MybatisplusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnum(){
        // INSERT INTO t_user ( name, age, sex ) VALUES ( ?, ?, ? )
        //==> Parameters: naonao(String), 28(Integer), 2(Integer)
        User user = new User();
        user.setUserName("naonao");
        user.setAge(28);
        user.setSex(SexEnum.FEMALE);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

}
