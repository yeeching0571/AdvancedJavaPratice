package com.JavaSenior.Thread.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yeeching
 * @version 1.0
 * @description: 创建线程的方式三：实现 Callable 接口  --JDK5.0 新特性
 * 如何理解实现 Callable 接口创建多线程比实现 Runnable 接口创建多线程强大？
 * 1. call() 可以有返回值
 * 2. call() 可以抛出异常，被外面的操作捕获，
 * @date 2023/7/19 20:59
 */
public class ThreadTest2 {
    public static void main(String[] args){
        //3. 创建 Callable 接口实现类的对象
        MyThread2 mt = new MyThread2();
        //4. 将此 Callable 接口实现类的对象作为传递到 FutureTask 构造器中，创建 FutureTask 的对象
        FutureTask futureTask = new FutureTask(mt);
        //5. 将 FutureTask 的对象作为参数传递到 Thread 类的构造器中，创建 Thread 对象，并调用 start()
        new Thread(futureTask).start();

        try {
            //6. 获取 Callable 中的 call 方法的返回值
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.fillInStackTrace());
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println(e.fillInStackTrace());
        }
    }
}
//1. 创建一个实现 Callable 的实现类
class MyThread2 implements Callable{
    //2. 实现 call 方法，将此线程需要执行的操作声明在 call() 中
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i <=50 ; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}