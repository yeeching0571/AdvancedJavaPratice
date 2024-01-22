package com.JavaSenior.Updates;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * Lambda 表达式的使用
 * 1.举例：(o1,o2) ->Integer.compare(o1,o2)
 * 2.格式：
 *      ->: Lambda操作符 或 箭头操作符
 *      ->左边：Lambda形参列表 (其实就是接口中的抽象方法的形参列表）
 *      ->右边：Lambda体  (其实就是重写的抽象方法的方法体)
 *
 * 3.Lambda表达式的使用：(分为6种情况介绍)
 *
 * 总结：->左边，Lambda形参列表的类型可以省略（类型推断）；如果 Lambda 形参列表只有一个参数，其一对()也可以省略。
 *     ->右边：Lambda体应该使用一对{}包裹。如果Lambda体只有一条执行语句（可能是return语句），可以省略这一对{}和 return 关键字。
 *
 * 4.Lambda表达式的本质：作为函数式接口的实例 （匿名对象实现接口）。
 *
 * 5.我们可以在一个接口上使用 @FunctionalInterface 注解，这样做可以检
 * 查它是否是一个函数式接口。同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
 *
 * 6.所以以前用匿名实现类表示的现在都可以用Lambda表达式来写。
 *
 *
 * @date 2023/12/28 20:25
 */
public class LambdaTest1 {

    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        System.out.println("****************************");

        Runnable r1 = () -> System.out.println("Zero Parameter, Zero Return");

        r1.run();
    }

    //语法格式二：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test2(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        con.accept("One Parameter, Zero Return");

        System.out.println("*************************");

        Consumer<String> con1 = (String s) ->{
            System.out.println(s);
        };
        con1.accept("One Parameter, Zero Return");
    }

    //语法格式三： 数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
    @Test
    public void test3(){
        Consumer<String> con2 = (s) ->{
            System.out.println(s);
        };
        con2.accept("One Parameter, Zero Return");
    }

    //语法格式四： Lambda 若只需要一个参数时， 参数的小括号可以省略
    @Test
    public void test4(){
        Consumer<String> con1 = s ->{
            System.out.println(s);
        };
        con1.accept("One Parameter, Zero Return");
    }

    //语法格式五： Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        int returnVal1 = com1.compare(12,43);
        System.out.println(returnVal1);

        System.out.println("**************************");

        Comparator<Integer> com2 = (o1, o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        int returnVal2 = com1.compare(67,43);
        System.out.println(returnVal2);
    }

    //语法格式六： 当 Lambda 体只有一条语句时， return 与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> com2 = (o1, o2)-> o1.compareTo(o2);
        System.out.println(com2.compare(23,45));
    }
}
