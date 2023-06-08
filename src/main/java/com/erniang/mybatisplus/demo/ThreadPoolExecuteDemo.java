package com.erniang.mybatisplus.demo;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.concurrent.*;

/**
 * @auther: Scott C C Liu
 * @create: 2023-05-18 2:55
 * @Description
 */
public class ThreadPoolExecuteDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,5,10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutorFactoryBean());

        //ExecutorService pool = Executors.newFixedThreadPool(4);

        //执行任务
        for (int i = 0; i < 10; i++) {
            int index = i;
            poolExecutor.execute( ()-> System.out.println("i:"+index+"execute!"));
        }
        //关闭线程池
        poolExecutor.shutdown();
        //Integer.MAX_VALUE

    }


}
