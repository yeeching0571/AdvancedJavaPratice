package com.JavaSenior.Thread.excerise;

/**
 * @author yeeching
 * @version 1.0
 * @description: 线程练习：创建3个窗口卖票，总票数为100张. 使用继承 Thread 类的方式实现会出现线程安全问题（100出现了3次）
 * @date 2023/7/18 14:57
 */
public class WindowTest {
    public static void main(String[] args) {
        WindowThread wth1 = new WindowThread();
        WindowThread wth2 = new WindowThread();
        WindowThread wth3 = new WindowThread();
        wth1.setName("窗口1");
        wth2.setName("窗口2");
        wth3.setName("窗口3");
        wth1.start();
        wth2.start();
        wth3.start();

    }
}

class WindowThread extends Thread{
    private static int ticket = 100;
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
