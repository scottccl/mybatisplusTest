package com.erniang.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.erniang.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.naming.event.ObjectChangeListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-03 12:22
 * @Description
 */

@Repository
public interface UserMapper extends BaseMapper<User>{

    /**
     * 根据id查询用户信息map集合
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);

    /**
     * 通过年龄查询用户并分页
     * @param page ： mybatis-plus所提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age")Integer age);


}
