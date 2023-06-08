package com.erniang.mybatisplus;

import com.erniang.mybatisplus.mapper.UserMapper;
import com.erniang.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-03 12:26
 * @Description
 */
@SpringBootTest
public class MybatisplusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSeletctList() {
        System.out.println(("----- selectAll ------"));
        //SELECT id,name,age,email FROM user
        //SELECT uid AS id,name AS userName,age,email,is_deleted FROM t_user WHERE is_deleted=0
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testSelectOne(){
        System.out.println("====================");
        //SELECT id,name,age,email FROM user WHERE id=?
        User user = userMapper.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testInsert(){
        //INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        User user = new User();
        //user.setId(10L);
        user.setUserName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@erniang.com");
        int result = userMapper.insert(user);
        System.out.println("result="+result );
        System.out.println("id="+ user.getId());

    }

    @Test
    public void testDelete(){
        //DELETE FROM user WHERE id=?
        //Parameters: id=1653677281261961217L
        //int i = userMapper.deleteById(1653677281261961217L);
        //System.out.println( "delete resule = " + i);

        //DELETE FROM user WHERE name = ? AND age = ?
        //Parameters: 张三(String), 18(Integer)
        //Map<String, Object> map = new HashMap<>();
        //map.put("name", "张三");
        //map.put("age", 18);
        //int deleteByMap = userMapper.deleteByMap(map);
        //System.out.println("delete by map result="+ deleteByMap);

        //DELETE FROM user WHERE id IN ( ? , ? , ? )
        //==> Parameters: 1(Long), 2(Long), 3(Long)
        List<Long> list = new ArrayList(Arrays.asList(1L,2L,3L));
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result=" + result);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setUserName("李斯");
        user.setEmail("zhangsan@.erniang.com");
        // UPDATE user SET name=?, email=? WHERE id=?
        //==> Parameters: 李斯(String), zhangsan@.erniang.com(String), 4(Long)
        int result = userMapper.updateById(user);
        System.out.println("result="+ result);
    }

    @Test
    public void testSelect(){
        System.out.println("====================");
        // SELECT id,name,age,email FROM user WHERE id=?
        //==> Parameters: 1(Long)
        //User user = userMapper.selectById(1L);
        //System.out.println(user);

        //SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        //==> Parameters: 3(Long), 4(Long), 5(Long)
        //ArrayList<Long> list = new ArrayList<>(Arrays.asList(3L, 4L, 5L));
        //List<User> userList = userMapper.selectBatchIds(list);
        //userList.forEach(System.out::println);


        //SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        //==> Parameters: jack(String), 20(Integer)
        Map<String, Object> map = new HashMap<>();
        map.put("name", "jack");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }


    @Test
    public void testXmlCase(){
        Map<String, Object> map = userMapper.selectMapById(4L);
        System.out.println(map);
    }


}
