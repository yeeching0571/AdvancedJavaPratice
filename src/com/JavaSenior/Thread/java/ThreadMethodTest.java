package com.JavaSenior.Thread.java;

/**
 * @author yeeching
 * @version 1.0
 * @description:测试 Thread 中的常用方法
 * 测试 Thread 中的常用方法
 * 1. start(): 启动当前线程，调用当前线程的 run() 方法
 * 2. run(): 通常需要重写 Thread 类中的此方法，将线程要执行的操作声明在此方法中
 * 3. currentThread(): 静态方法，返回当前代码的线程
 * 4. getName(): 获取当前线程的名字
 * 5. setName(): 设置当前线程的名字
 * 6. yield(): 释放当前线程对 cpu 的执行权
 * 7. join(): 在线程 a 中调用线程 b 的 jion(), 此时线程 a 就进入阻塞状态，直到线程 b 完全执行后，线程 a 才
 *            结束阻塞状态
 * 8. sleep(long millitime): 让当前线程 “睡眠” millitime 毫秒，在此期间，当前线程阻塞
 * 9. isAlive(): 判断当前线程是否存活
 *
 * 线程的优先级  高优先级的线程要抢占低优先级线程 cpu 的执行权，但是只是从概率上讲，高优先级的线程有较高概率的执行。
 *             并不意味着执行完高优先级的线程再执行低优先级的。
 * 1.
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5
 * MAX_PRIORITY = 10
 * 2. 如何获取和设置当前线程的优先级
 *    getPriority(): 获取线程的优先级
 *    setPriority(int p): 设置线程的优先级
 * @date 2023/7/17 17:34
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        ThreadMethod tm = new ThreadMethod();
        tm.setName("测试线程");
        tm.start();
        System.out.println(tm.isAlive());
        new Thread() {
            @Override
            public void run() {
                currentThread().setName("主线程：");
                currentThread().setPriority(MIN_PRIORITY);
                for (int i = 0; i <= 50; i++) {
                    if (i % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ":  " + Thread.currentThread().getPriority() + " "+ i);
                    }

                    if (i == 30){
                        try{
                            tm.join();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

    }
}

class ThreadMethod extends Thread{
    @Override
    public void run() {
        for(int i=0; i<50; i++){
            System.out.println(Thread.currentThread().getName() +": " + Thread.currentThread().getPriority()  + " " +i);

            if (i == 30){
                yield();
            }
        }

    }
}
