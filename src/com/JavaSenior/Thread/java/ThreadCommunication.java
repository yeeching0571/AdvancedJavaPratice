package com.JavaSenior.Thread.java;

/**
 * @author yeeching
 * @version 1.0
 * @description: 线程通信例子：使用两个线程交替打印 1-100。
 * 涉及到的三个方法：
 * wait(): 一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器。
 * notify(): 一旦执行此方法，就会唤醒被 wait 的一个线程。如果有多个线程被 wait, 就唤醒优先级高的。
 * notifyAll(): 一旦执行此方法，就会唤醒所有被 wait 的线程。
 *
 * 说明：
 * 1. 这三个方法只能出现在同步代码块或同步方法中。
 * 2. 这三个方法的调用者必须是步代码块或同步方法中的同步监视器。
 * 3. 这三个方法定义在 Object 类中。
 *
 * sleep() 和 wait() 的异同？
 * 1. 相同点：一旦执行方法，都可以使当前线程进入阻塞状态。
 * 2. 不同点：1) 两个方法声明的位置不同： Thread 类中声明 sleep(), Object 类中声明 wait()
 *          2) sleep() 可以在任何需要的场景下调用， wait()必须在同步代码块或者同步方法中。
 *          3) 同步监视器：如果两个方法都在同步代码块或者同步方法中使用，sleep() 不会释放锁， wait()会释放锁。
 * @date 2023/7/19 15:45
 */
class Number implements Runnable{
    private int num = 1;

    @Override
    public void run() {
        while (true){
            synchronized (this) {
                notify();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ( num <= 100){
                    System.out.println(Thread.currentThread().getName() + " " + num);
                    num++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        Number num = new Number();
        Thread t1 = new Thread(num);
        Thread t2 = new Thread(num);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
