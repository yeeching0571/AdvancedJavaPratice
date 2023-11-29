package com.JavaSenior.Thread.java;

/**
 * @author yeeching
 * @version 1.0
 * @description: 使用同步方法(synchronized)解决实现 Runnable 接口方式产生的线程安全问题
 *               存在死循环
 *如果操作共享数据的代码完整地声明在一个方法中，我们不妨将此方法声明同步。
 * 1. 同步方法仍涉及到同步监视器，只是不需要我们显式声明。
 * 2. 非静态的同步方法，同步监视器是：this
 *    非静态的同步方法，同步监视器是：当前类本身
 * @date 2023/7/19 10:19
 */
public class WindowTest3 {
    public static void main(String[] args) {
        WindowThread3 w = new WindowThread3();

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

class WindowThread3 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            sell();
        }
    }
    private synchronized void sell(){
        if (ticket > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 票号： " + ticket);
            ticket--;
        }
    }
}

