package com.JavaSenior.Reflection;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * 静态代理举例
 * 特点：代理类和被代理类在编译期间就确定下来。
 * 
 * @date 2023/12/28 16:03
 */

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//拿被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理类工厂做一些后续收尾工作");
    }
}

//被代理类
class AntaClothFactory implements ClothFactory{
    @Override
    public void produceCloth() {
        System.out.println("安踏工厂生产一批运动服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        AntaClothFactory anta = new AntaClothFactory();
        //创建代理类对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(anta);

        proxyClothFactory.produceCloth();
    }
}
