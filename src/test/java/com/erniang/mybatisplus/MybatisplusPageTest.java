package com.erniang.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erniang.mybatisplus.mapper.ProductMapper;
import com.erniang.mybatisplus.mapper.UserMapper;
import com.erniang.mybatisplus.pojo.Product;
import com.erniang.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-04 17:27
 * @Description
 */

@SpringBootTest
public class MybatisplusPageTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    ProductMapper productMapper;

    @Test
    public void testPage(){
        //SELECT COUNT(*) AS total FROM t_user WHERE is_deleted = 0
        Page<User> page = new Page(2,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage.getPages());
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getSize());
        System.out.println(userPage.getTotal());
    }

    @Test
    public void testPage01(){
        //SELECT COUNT(*) AS total FROM t_user WHERE age > ?
        //==> Parameters: 20(Integer)
        //select uid, name, age, email from t_user where age > ? order By age ASC LIMIT ?,?
        //==> Parameters: 20(Integer), 3(Long), 3(Long)
        Page<User> page = new Page<>(2,3);
        Page<User> userPage = userMapper.selectPageVo(page, 20);
        System.out.println(userPage.getPages());
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getSize());
        System.out.println(userPage.getTotal());
    }

    @Test
    public void test01(){
        Product product1 = productMapper.selectById(1L);
        product1.setPrice(product1.getPrice() + 500);

        Product product2 = productMapper.selectById(1L);
        product2.setPrice(product2.getPrice() - 300);

        productMapper.updateById(product1);
        int res = productMapper.updateById(product2);

        if(res == 0){
            product2 = productMapper.selectById(1L);
            product2.setPrice(product2.getPrice() - 300);
            productMapper.updateById(product2);
        }

        Product product3 = this.productMapper.selectById(1L);
        System.out.println(product3.getPrice());
    }

}

