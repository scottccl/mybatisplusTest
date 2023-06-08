package com.erniang.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.erniang.mybatisplus.mapper.UserMapper;
import com.erniang.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-04 14:12
 * @Description
 */

@SpringBootTest
public class MybatisplusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectWrapper(){
        //查询用户信息：名字包含‘a’，年龄再20-30之间且email不为空
        //SELECT uid AS id,name AS userName,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        //==> Parameters: %a%(String), 20(Integer), 30(Integer)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a")
                .between("age", 20,30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void testWrapper1(){
        //查询用户信息，按照年龄降序排列，若年龄相同，则按照id升序排列
        //SELECT uid AS id,name AS userName,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age DESC,uid ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderByDesc("age").orderByAsc("uid");
        queryWrapper.orderBy(true,false, "age")
                .orderBy(true, true, "id");

        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testDelete(){
        //删除email为空的记录
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNull("email");
        int result = userMapper.delete(wrapper);
        System.out.println(result);
    }

    @Test
    public void testUpdate(){
        //将（年龄大于20并且用户名包含a）或者邮箱为null的用户信息修改
        //UPDATE t_user SET name=?, email=? WHERE is_deleted=0 AND (age > ? AND name LIKE ? OR email IS NULL)
        //==> Parameters: 小米(String), update@qq.com(String), 20(Integer), %a%(String)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20)
                .like("name", "a")
                .or(true)
                .isNull("email");
        User user = new User();
        user.setUserName("小米");
        user.setEmail("update@qq.com");

        int update = userMapper.update(user, wrapper);
        System.out.println(update);
    }

    @Test
    public void testUpdate01(){
        //将用户名中间包含‘a’并且（年龄大于20或者邮箱为null）的信息修改
        //UPDATE t_user SET name=?, email=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        //==> Parameters: 华为(String), huawei@hw.com(String), %a%(String), 20(Integer)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "a")
                .and(i-> i.gt("age", 20).or().isNull("email"));

        User user = new User();
        user.setUserName("华为");
        user.setEmail("huawei@hw.com");

        int result = userMapper.update(user, wrapper);
        System.out.println(result);
    }

    @Test
    public void testUpdate06(){
        //查询用户的用户名，年龄，邮箱
        //SELECT name,age,email FROM t_user WHERE is_deleted=0
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("name", "age", "email");
        List<Map<String, Object>> mapList = userMapper.selectMaps(wrapper);
        mapList.forEach(System.out::println);
    }

    @Test
    public void testUpdate07(){
        //SELECT uid AS id,name AS userName,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid>10))
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("uid", "select uid from t_user where uid>10");
        List<User> list = userMapper.selectList(wrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void testUpdateWrapper(){
        //UPDATE t_user SET name=?,email=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
        //==> Parameters: vivo(String), vivo@vv.com(String), %华%(String), 20(Integer)
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name", "华")
                .and(i->i.gt("age", 20).or().isNull("email"));

        updateWrapper.set("name", "vivo").set("email","vivo@vv.com");

        int result = userMapper.update(null, updateWrapper);
        System.out.println(result);
    }

    @Test
    public void testUpdate09(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        User user = new User();
        user.setUserName("华为");
        user.setEmail("huawei@hw.com");

        int result = userMapper.update(user, wrapper);
        System.out.println(result);
    }


}
