package com.JavaSenior.Updates;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * 方法引用的使用
 *
 * 1.使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用！
 *
 * 2.方法引用，本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以
 *   方法引用，也是函数式接口的实例。
 *
 * 3. 使用格式：  类(或对象) :: 方法名
 *
 * 4. 具体分为如下的三种情况：
 *    情况1     对象 :: 非静态方法
 *    情况2     类 :: 静态方法
 *
 *    情况3     类 :: 非静态方法
 *
 * 5. 方法引用使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的
 *    形参列表和返回值类型相同！（针对于情况1和情况2）
 * @date 2023/12/29 10:22
 */
public class MethodReferenceTest {

    //情况一：对象::实例方法
    //Consumer 中的 void accept(T t)
    //PrintStream 中的 void println(T t)
    @Test
    public void test1(){
        Consumer<String> con = str -> System.out.println(str);
        con.accept("Hello");

        System.out.println("********************");
        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("Hi");
    }

    //情况一：对象::实例方法
    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2(){
        Employee emp = new Employee(1001, "Tom",23, 5600);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("********************");

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }

    //情况二：类::静态方法
    // Comparator中的int compare(T t1, T t2)
    // Integer中的int compare(T t1, T t2)
    @Test
    public void test3(){
        Comparator<Integer> com1 = (n1, n2) -> Integer.compare(n1, n2);
        System.out.println(com1.compare(12,34));

        System.out.println("********************");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(34, 23));
    }

    //情况二：类::静态方法
    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4(){
        Function<Double, Long> func1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println(func1.apply(8.9));

        System.out.println("********************");

        Function<Double, Long> func2 = Math::round;
        System.out.println(func2.apply(7.1));

    }

    //情况三：类::实例方法（有难度）
    //Comparator 中的 int compare(T t1, T t2)
    //String 中的 int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "ade"));

        System.out.println("********************");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("er","w22"));
    }

    //情况三：类::实例方法
    //BiPredicate 中的 boolean test(T t1, T t2);
    //String 中的 boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("ab","ab"));

        System.out.println("********************");

        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("ab","ad"));
    }

    //情况三：类::实例方法
    //Function中的R apply(T t)
    //Employee中的String getName();
    @Test
    public void test7(){
        Employee emp = new Employee(1001, "Jerry",23, 5600);

        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(emp));;

        System.out.println("********************");

        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(emp));

    }
}
