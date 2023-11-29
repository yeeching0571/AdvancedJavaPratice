package com.JavaSenior.Classes.java;

import org.junit.Test;

/**
 * @author yeeching
 * @version 1.0
 * @description: 关于 StringBuffer 和 StringBuilder 的使用
 * String: 不可变的字符序列；底层使用 char[] 存储，
 * String str1 = new String(abc);// char[] value = new char[]{'a','b','c'}
 *
 * StringBuffer: 可变的字符序列；底层使用 char[] 存储，线程安全的，效率低
 * StringBuffer sb1 = new StringBuffer("abc");// char[] value = new char["abc".length + 16]
 * sb1.append('d');// value[3] = 'd';
 * 如果要添加的数据底层放不下，就需要扩容底层的数组。默认情况下，扩容为原来容量的 2 倍 +2，同时将原有数组中的元素复制到新的数组中
 * 建议使用： StringBuffer(int capacity) 或 StringBuilder(int capacity);
 *
 * StringBuilder: 可变的字符序列；底层使用 char[] 存储，jdk5.0新增，线程不安全，效率高
 *
 * StringBuffer常见方法
 * StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接
 * StringBuffer delete(int start,int end)：删除指定位置的内容
 * StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str
 * StringBuffer insert(int offset, xxx)：在指定位置插入xxx
 * StringBuffer reverse() ：把当前字符序列逆转
 * public int indexOf(String str)
 * public String substring(int start,int end)
 * public int length()
 * public char charAt(int n )
 * public void setCharAt(int n ,char ch)
 *
 * 对比 String StringBuffer StringBuilder 三者的效率
 * 从高到低：StringBuilder > StringBuffer > String
 *
 * String StringBuffer StringBuilder 之间的转换
 * String ---> StringBuffer StringBuilder: 调用 StringBuffer StringBuilder 构造器
 * StringBuffer StringBuilder ---> String: ①调用 String 构造器；②StringBuffer、StringBuilder 的 toString() 方法
 * @date 2023/7/25 15:37
 */
public class StringBufferBuilderTest {
    @Test
    public void test3(){
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
//开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));
    }

    @Test
    public void test2(){
        StringBuffer sb1 = new StringBuffer("abcd");
        sb1.append('e');
        sb1.append("fg");
        System.out.println(sb1);
        sb1.delete(1,3);
        System.out.println(sb1);
        sb1.replace(2,4,"hello");
        System.out.println(sb1);
        sb1.insert(1,"bc");
        System.out.println(sb1);
    }
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");// char[] value = new char["abc".length + 16]
        sb1.setCharAt(0, 'm');
        sb1.append('d');// value[3] = 'd';
        System.out.println(sb1);
    }
}
