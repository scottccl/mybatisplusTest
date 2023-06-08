package com.erniang.mybatisplus.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-11 19:04
 * @Description
 */
public class DemoTest {

    String aa = new String("good");
    char[] cc = {'a','b', 'c'};

    public static void main(String[] args) {
        //DemoTest test = new DemoTest();
        //test.change(test.aa, test.cc);
        //System.out.println(test.aa+"and ");
        //System.out.println(test.cc);


        List<Integer> list = new ArrayList<>();
        for (int i=0;i< 15; i++){
            list.add(i);
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            int res = iterator.next();
            if (res%2==1) {
                 //list.remove(res);   // 使用对象的remove方法删除会破坏迭代器的循环
                iterator.remove();
            }else{
                System.out.println(res);
            }
        }
        System.out.println(list);

    }

    public void change(String str, char[] chars){
        str = " test.ok";
        chars[0] = 'g';
    }

    public void test2(){
        //long a = oxfff;
        long a1 = 0xfff;
        float b = 0.233f;
        System.out.println(b);
        System.out.print(Integer.parseInt("F", 16));
    }






}
