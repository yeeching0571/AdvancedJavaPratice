package com.JavaSenior.Updates;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * Lambda表达式的使用举例
 *
 * @date 2023/12/28 18:41
 */
public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Implementation");
            }
        };

        r1.run();

        System.out.println("****************************");

        Runnable r2 = () -> System.out.println("Lambda Expression");

        r2.run();
    }

    @Test
    public void test2(){
        System.out.println("*************Lambda表达式1***************");
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        int compare1 = com1.compare(12,23);
        System.out.println(compare1);

        System.out.println("***********Lambda表达式2*****************");

        //Lambda 表达式的写法
        Comparator<Integer> com2 = ( o1, o2) -> Integer.compare(o1,o2);
        int compare2 = com2.compare(78,23);
        System.out.println(compare2);

        System.out.println("*************方法引用***************");

        //Lambda 方法引用的写法
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com2.compare(78,23);
        System.out.println(compare3);
    }
}
