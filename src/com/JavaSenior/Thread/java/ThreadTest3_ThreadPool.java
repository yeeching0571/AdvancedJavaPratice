package com.JavaSenior.Thread.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yeeching
 * @version 1.0
 * @description: 创建线程的方式四：使用线程池
 * 好处：
 * 1. 提高响应速度（减少了创建新线程的时间）
 * 2. 降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3. 便于线程管理
 *        corePoolSize：核心池的大小
 *        maximumPoolSize：最大线程数
 *        keepAliveTime：线程没有任务时最多保持多长时间后会终止
 *
 * @date 2023/7/20 16:00
 */

class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
            
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 1){
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }

        }
    }
}

public class ThreadTest3_ThreadPool {
    public static void main(String[] args) {
        //1. 提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
//        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);


        //2. 执行指定线程的操作。需要提供实现 Runnable 或 Callable 接口实现类的对象
        service.execute(new NumberThread());//适用于 Runnable
        service.execute(new NumberThread1());
        //service.submit();//适用于 Callable

        //3. 调用结束后关闭线程
        service.shutdown();
    }
}
