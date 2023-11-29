package com.JavaSenior.Thread.excerise;

/**
 * @author yeeching
 * @version 1.0
 * @description: 单例模式中的懒汉式 --> 线程安全
 * @date 2023/7/19 12:01
 */
public class LazyMode {
}
class Bank{
    private static Bank instance = null;
    private Bank(){

    }
    public Bank getBank(){
        //方式一：效率稍差
//        synchronized (Bank.class){
//            if (instance == null){
//                instance = new Bank();
//        }
//        return instance;
//        }
        //方式二 效率更高
        if (instance == null){
            synchronized (Bank.class){
                if(instance ==null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
