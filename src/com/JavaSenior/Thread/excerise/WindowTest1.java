package com.JavaSenior.Thread.excerise;

/**
 * @author yeeching
 * @version 1.0
 * @description: 线程练习：创建3个窗口卖票，总票数为100张.使用实现 Runnable 接口的方式来实现，同样存在线程安全问题
 * @date 2023/7/18 15:56
 */
public class WindowTest1 {
    public static void main(String[] args) {
        WindowThread1 w = new WindowThread1();

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
class WindowThread1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket >0){
                System.out.println(Thread.currentThread().getName()+ " 票号： " + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
