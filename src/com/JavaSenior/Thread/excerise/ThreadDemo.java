package com.JavaSenior.Thread.excerise;
import com.JavaSenior.Thread.java.*;
/**
 * @author yeeching
 * @version 1.0
 * @description:创建两个线程，一个计算100以内的奇数，另一个创建100以内的偶数
 * @date 2023/7/17 16:29
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //方法一
//        Thread1 myEvenThread = new Thread1();
//        Thread2 myOddThread = new Thread2();
//        myEvenThread.start();
//        myOddThread.start();

        //方法二 创建匿名子类的方法
        new Thread(){
            @Override
            public void run() {
                for(int i=0; i<=100; i++){
                    if (i%2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":  " + i);
                    }
                    if (i == 60){
                        yield();
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for(int i=0; i<=100; i++){
                    if (i%2 == 1){
                        System.out.println(Thread.currentThread().getName() + ":  " + i);
                    }
                }
            }
        }.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        for(int i=0; i<=100; i++){
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() + ":  " + i);
            }
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for(int i=0; i<=100; i++){
            if (i%2 == 1){
                System.out.println(Thread.currentThread().getName() + ":  " + i);
            }
        }
    }
}
