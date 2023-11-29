package com.JavaSenior.Thread.java;

/**
 * @author yeeching
 * @version 1.0
 * @description: 多线程测试，输出20以内的偶数
 * 每个线程拥有自己独立的：栈、程序计数器；多个线程共享同一个进程中的结构：方法区、堆。
 * 多线程创建，方式一：继承于 Thread 类
 * 1. 创建一个继承于 Thread 子类的类
 * 2. 重写 Thread 类的 run()
 * 3. 创建一个子类对象
 * 4. 通过对象调用 start()

注意
1)不能通过直接执行 run() 来开启多线程，要通过 start()
2)要用到多个线程时，需要创建多个 线程对象
 * @date 2023/3/12 10:41
 */

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ":  " + i);
            }

        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println(Thread.currentThread().getName() + ":  " + "hello");
    }
    }

