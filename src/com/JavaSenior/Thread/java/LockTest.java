package com.JavaSenior.Thread.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yeeching
 * @version 1.0
 * @description: 解决线程安全问题的方式三  --JDK5.0 新增
 * 1. synchronized 和 Lock 的异同？
 *    相同：二者都可以解决线程安全问题
 *    不同：synchronised 机制在执行完同步代码后，自动释放同步监视器
 *         Lock 需要手动启动同步 (lock())，结束同步也有要手动操作 (unlock())
 * 2. 优先使用顺序
 * Lock --> 同步代码块（已经进入了方法体，分配了相应资源） --> 同步方法（在方法体之外）
 * @date 2023/7/19 14:47
 */
public class LockTest {
    public static void main(String[] args) {
        Window w = new Window();

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
class Window implements Runnable {
    private int ticket = 100;
    //1. 实例化 ReentrantLock
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                //2. 调用锁定方法 lock()
                lock.lock();
                if (ticket >0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+ " 票号： " + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                //3. 调用解锁方法 unlock()
                lock.unlock();
            }
        }
    }
}
