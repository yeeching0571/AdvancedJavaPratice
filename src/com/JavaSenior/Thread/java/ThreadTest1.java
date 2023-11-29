package com.JavaSenior.Thread.java;

/**
 * @author yeeching
 * @version 1.0
 * @description: 创建线程的方式二
 * 创建线程的方式二：实现 Runnable 接口
 * 1. 创建一个实现了 Runnable 接口的类
 * 2. 实现类去实现 Runnable 中的抽象方法 run()
 * 3. 创建实现类的对象
 * 4. 将实现类作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
 * 5， 通过 Thread 类的对象调用 start()
 *
 * 比较创建线程的两种方式
 * 开发中优先选择：实现 Runnable 接口的方式
 * 原因： 1) 实现的方式没有类的单继承性的局限
 *       2) 实现的方式更适合来处理多个线程有共享数据的情况（参考 WindowTest1 中的例子）
 *
 * 联系： public class Thread implements Runnable
 * 相同点： 两种方式都需要重写 Runnable 的 run() 方法
 * @date 2023/7/18 15:08
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3. 创建实现类的对象
        MyThread1 mt1 = new MyThread1();
        //4. 将实现类作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
        Thread t1 = new Thread(mt1);
        t1.setName("线程1");
        //5. 通过 Thread 类的对象调用 start()
        t1.start();
    }
}

//1. 创建一个实现了 Runnable 接口的类
class MyThread1 implements Runnable{
    //2. 实现类去实现 Runnable 中的抽象方法 run()
    @Override
    public void run() {
        for(int i=0; i<50; i++){
            if (i%2 == 0){
                System.out.println(Thread.currentThread().getName() +": " +i);
            }
        }
    }
}
