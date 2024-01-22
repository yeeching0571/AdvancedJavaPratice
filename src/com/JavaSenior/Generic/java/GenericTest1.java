package com.JavaSenior.Generic.java;

import org.junit.Test;

import java.util.List;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 *
 * 如何定义泛型结构：泛型类、泛型接口; 泛型方法。
 *
 * 一、泛型类
 * 子类在继承带泛型的父类时，如果指明泛型类型，则实例化子类对象时，不再需要声明泛型。例如：
 *      public class SubOrder extends Order<Integer>{}  // SubOrder 不是泛型类
 *      public class SubOrder<T> extends Order<T>{}     // SubOrder 仍是泛型类
 *
 * 其它细节：
 * 1. 泛型类可能有多个参数，此时应将多个参数一起放在尖括号内。比如：<E1,E2,E3>
 * 2. 泛型类的构造器如下： public GenericClass(){}。而下面是错误的： public GenericClass<E>(){}
 * 3. 实例化后，操作原来泛型位置的结构必须与指定的泛型类型一致。
 * 4. 泛型不同的引用不能相互赋值。尽管在编译时 ArrayList<String> 和 ArrayList<Integer> 是两种类型，但是，在运行时只有一个ArrayList被加载到JVM中。
 * 5. 泛型如果不指定，将被擦除，泛型对应的类型均按照Object处理，但不等价于Object。 经验： 泛型要使用一路都用。要不用，一路都不要用。
 * 6. 如果泛型结构是一个接口或抽象类，则不可创建泛型类的对象。
 * 7. jdk1.7，泛型的简化操作： ArrayList<Fruit> flist = new ArrayList<>();
 * 8. 泛型的指定中不能使用基本数据类型，可以使用包装类替换。
 * 9. 静态方法中不能使用泛型。
 * 9. 在类/接口上声明的泛型，在本类或本接口中即代表某种类型，可以作为非静态
 *    属性的类型、非静态方法的参数类型、非静态方法的返回值类型。但在静态方法中不能使用类的泛型。
 * 10. 异常类不能是泛型的
 * 11. 不能使用 new E[]。但是可以： E[] elements = (E[])new Object[capacity];
 *     参考： ArrayList源码中声明： Object[] elementData， 而非泛型参数类型数组。
 * 12.父类有泛型，子类可以选择保留泛型也可以选择指定泛型类型：详情见 test2()
 *    子类不保留父类的泛型：按需实现
 *      没有类型 擦除
 *      具体类型
 *    子类保留父类的泛型：泛型子类
 *      全部保留
 *      部分保留
 *  子类必须是“富二代”，子类除了指定或保留父类的泛型，还可以增加自己的泛型
 *
 * 二、泛型方法
 * 泛型方法指在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。换句话说，泛型方法所属的类是不是泛型类都没有关系。
 * 泛型方法是可以声明为静态的。 原因：泛型参数是在调用方法时确定的。并非在实例化时确定。
 *
 * @date 2023/11/29 16:38
 */
public class GenericTest1 {
    @Test
    public void test1(){
        // 如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为 object 类型
        // 要求：如果定义了带泛型的类，建议实例化时要指明类的泛型
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("abc");

        // 实例化时，指明类的泛型
        Order<String> order1 = new Order<>("OrderName", 123, "Description");
        order1.setOrderT(" A generic class");
        System.out.println(order1);
    }

    @Test
    public void test2(){
        class Father<T1, T2> {
        }
        // 子类不保留父类的泛型
          // 1)没有类型 擦除
        class Son<A, B> extends Father{//等价于class Son extends Father<Object,Object>{
        }
          // 2)具体类型
        class Son2<A, B> extends Father<Integer, String> {
        }
        // 子类保留父类的泛型
          // 1)全部保留
        class Son3<T1, T2, A, B> extends Father<T1, T2> {
        }
          // 2)部分保留
        class Son4<T2, A, B> extends Father<Integer, T2> {
        }
    }

    //测试泛型方法
    @Test
    public void test3(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{2,6,3,7};
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }

}
