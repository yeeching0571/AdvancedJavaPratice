package com.JavaSenior.Updates;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *
 * 二、数组引用
 *      可以把数组看错是一个特殊的类，则写法与构造器引用一致
 *
 * @date 2023/12/29 17:35
 */
public class ConstructorReferenceTest {

    //构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        System.out.println("********************");

        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }

    //Function中的R apply(T t)
    @Test
    public void test2(){
        Function<Integer, Employee> func1 = id -> new Employee(id);
        System.out.println(func1.apply(10002));

        System.out.println("********************");

        Function<Integer, Employee> func2 = Employee::new;
        System.out.println(func2.apply(10003));

    }

    //BiFunction中的R apply(T t, U u)
    @Test
    public void test3(){
        BiFunction<Integer,String, Employee> func1 = (id, name) -> new Employee(id, name);
        System.out.println(func1.apply(23, "Rita"));

        System.out.println("********************");

        BiFunction<Integer,String, Employee> func2 = Employee::new;
        System.out.println(func1.apply(21, "Andy"));

    }

    //数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
        Function<Integer, String[]> func1 = length -> new String[length];
        String[] arr1 = func1.apply(5);
        System.out.println(Arrays.toString(arr1));

        System.out.println("********************");

        Function<Integer, String[]> func2 = String[]::new;
        String[] arr2 = func2.apply(3);
        System.out.println(Arrays.toString(arr2));


    }
}
