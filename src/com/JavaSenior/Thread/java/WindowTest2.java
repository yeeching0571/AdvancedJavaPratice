package com.JavaSenior.Thread.java;

/**
 * @author yeeching
 * @version 1.0
 * @description: 线程练习：创建3个窗口卖票，总票数为100张.使用实现 Runnable 接口的方式来实现
 * 1. 问题：卖票过程中，出现了重票、错票 --> 出现线程安全问题
 * 2. 问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参也在操作车票
 * 3. 如何解决：当一个线程在操作 ticket 时，其它线程在其操作结束前都不能操作，即使出现线程阻塞也不例外
 * 4. 在 Java 中，可以通过同步机制来解决线程安全问题。
 *
 * 方式一：同步代码块
 *   synchronized(同步监视器){
 *       //需要被同步的代码（即操作共享数据的代码。共享数据：多个线程共同操作的变量，如 ticket）
 *   }
 *   说明：1. 同步监视器，俗称锁。任何一个类的对象都可以充当锁。
 *              要求：多个线程必须共用同一把锁。
 *              补充：在实现 Runnable 接口创建多线程的方式中，可以考虑使用 this 作为锁。
 *                   在继承 Thread 类创建多线程的方式中，慎用 this 充当同步监视器，考虑使用当前类充当同步监视器
 * 方式二：同步方法
 *       如果操作共享数据的代码完整地声明在一个方法中，我们不妨将此方法声明同步。
 *       1. 同步方法仍涉及到同步监视器，只是不需要我们显式声明。
 *       2. 非静态的同步方法，同步监视器是：this
 *          非静态的同步方法，同步监视器是：当前类本身
 *
 * 同步的方式解决了线程安全问题，但是在操作同步代码时，只能有一个线程参与，其它线程等待。相当于是一个单线程的过程，效率低。
 * @date 2023/7/19 9:07
 */
public class WindowTest2 {
    public static void main(String[] args) {
        WindowThread2 w = new WindowThread2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowThread2 implements Runnable{
    private int ticket = 100;
    // bnObject obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized(this){ //synchronized (obj) {
                {
                    if (ticket > 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " 票号： " + ticket);
                        ticket--;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}