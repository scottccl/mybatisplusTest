package com.erniang.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.erniang.mybatisplus.enums.SexEnum;
import lombok.*;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-03 12:03
 * @Description
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
//设置实体类对应表明
@TableName("user")
public class User {

    // @TableId将属性所对应的字段指定为主键, value属性用于指定主键字段
    //type属性用来定义主键策略； 默认是IdType.ASSIGN_ID:基于雪花算法的策略生成id，与数据库是否设置自增无关；
    // IdType_AUTO:使用数据库的自增策略，注意，该类型请确保数据库设置了id自增，否则无效。
    //@TableId(value="uid", type = IdType.AUTO)
    @TableId("id")
    private Long id;
    //@TableField：指定属性对应的表中的字段
    @TableField("name")
    private String userName;
    private Integer age;
    private String email;
    private SexEnum sex;
    @TableLogic
    private Integer isDeleted;
}
