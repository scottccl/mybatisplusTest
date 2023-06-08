package com.erniang.mybatisplus.suiji;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-11 15:22
 * @Description
 */
@SpringBootTest
public class Test01 {

    @Test
    public void test01(){
        int a =3;
        int b = a<<3;
        System.out.println(a + ">>>" + b);

    }

    @Test
    public void test2(){
        //long a = oxfff;
        //long a1 = 0xfff;
        //float b = 3.3f;
        //System.out.println(b);
        //System.out.print(Integer.parseInt("A", 16));
        //System.out.println(0.7E-3);
        int i = 9;
        switch (i){
            case 0: System.out.println("zero"); break;
            case 1:
                System.out.println("one");
            default: System.out.println("default");
            case 2:
                System.out.println("two");
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
        }

        //i=1;
        //switch (i){
        //    case 1:
        //        System.out.println("one");
        //        //break;
        //    case 0:
        //        System.out.println("zero");
        //        //break;
        //    case 2:
        //        System.out.println("two");
        //        //break;
        //    default:
        //        System.out.println("default");
        //        break;
        //}
    }

    @Test
    public void test03(){
        int i=1;
        int j;
        j=i++;
        System.out.println( i +"..." + j);
        //float a = 2.0;
        double b = 2.0;
        long c = 2123L;

        //String s = "abc";
        //s.length();
        ////super;
        ////String 3number = "";
        //String $number = " ";
        //
        //int a  = 022; int b=0x22;

        float[] f[] = new float[6][6];
        float ff[][] = new float[6][6];

    }

    long arr[] = new long[10];
    private float f=1.0f;
    @Test
    public void test04(){
        System.out.println(arr[6]);  //0

        boolean m=true;
        if(m==false){
            System.out.println("false");
        }else {
            System.out.println("true");
        }


    }






}
