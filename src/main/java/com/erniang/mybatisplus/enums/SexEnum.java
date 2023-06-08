package com.erniang.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-04 22:30
 * @Description
 */
@Getter
public enum SexEnum {
    MEAL(1, "男"),
    FEMALE(2, "女");

    @EnumValue  //将注解所标注的属性的值存储到数据库中
    private Integer sex;
    private String sexValue;

    SexEnum(Integer sex, String sexValue) {
        this.sex = sex;
        this.sexValue = sexValue;
    }
}
