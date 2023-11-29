package com.JavaSenior.Classes.java;

import org.junit.Test;

/**
 * @author yeeching
 * @version 1.0
 * @description: String的使用
 * String: 字符串，使用一对 "" 引起来表示
 * 1. String 声明为 final，不可被继承
 * 2. String 实现了 Serializable 接口：表示字符串是支持序列化的
 *           实现了 Comparable 接口：表示 String可以比较大小
 * 3. String 内部定义了 final char[] value 用于存储字符串数据
 * 4. String 代表不可变的字符序列。
 *      体现：1. 当对字符串重新赋值时，需要重写指定内存区域，不能使用原有的 value 进行赋值
 *           2. 当对字符串进行拼接操作时，需要重写指定内存区域，不能使用原有的 value 进行赋值
 *           3. 当调用 String 的 replace() 方法修改字符或字符串时，需要重写指定内存区域，不能使用原有的 value 进行赋值
 * 5. String 的实例化方式
 *      方式一：通过字面量定义方式
 *          通过字面量的方式给一个字符串赋值，此时的字符串值声明在字符串常量池中。字符串常量池是不会存储相同字符串的。
 *      方式二：通过 new + 构造器的方式 (String s = new String("abc"))
 *          这种方式在内存中创建了两个对象，一个是堆空间中的 new 结构，另一个是 char[] 对应的常量池中的数据："abc"
 * @date 2023/7/21 16:27
 */
public class StringTest {
    public static void main(String[] args) {
        //字面量定义方式，存储在方法区的字符串常量池中
        String s1 = "abc";
        String s2 = "abc";
//        s1 = "hello";
        System.out.println(s1 == s2);//比较s1和s2的地址值
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("*******************");
        String s3 = "abc";
        System.out.println(s2 == s3);
        s3 += "def";
        System.out.println(s2 == s3);

        System.out.println("*******************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s4 == s5);

        System.out.println("*******************");
        //通过 new + 构造器的方式：此时 s6 和 s7 保存的是堆空间的地址值，堆空间中存储的是常量池中对应字符串所在空间的地址，数据存储在常量池中。
        String s6 = new String("JavaEE");
        String s7 = new String("JavaEE");
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s6 == s7);

        System.out.println("*******************");
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        System.out.println(p1.name.equals(p2.name));

    }

}

 class Person{
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
