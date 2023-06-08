package com.erniang.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-04 18:38
 * @Description
 */
@Data
public class Product {

    private Long id;
    private String name;
    private Float price;
    //用来标注版本号
    @Version
    private Integer version;

}
