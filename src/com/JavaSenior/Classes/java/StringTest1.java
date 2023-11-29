package com.JavaSenior.Classes.java;

import org.junit.Test;
import java.util.Arrays;

/**
 * @author yeeching
 * @version 1.0
 * @description: String 类与其它结构之间的转换
 *
 * String 与基本数据类型、包装类之间的转换
 * String ---> 基本数据类型、包装类: 调用包装类的静态方法：parseXxx(str)
 * 基本数据类型、包装类 ---> String: 调用 String 重载的 valueOf(xxx)
 *
 * String --->  char[]: 调用 String 的 toCharArray()
 * char[] --->  String: 调用 String 的构造器
 *
 * String ---> byte[]: 调用 String 的 getByte()
 * byte[] ---> String: 调用 String 的构造器
 * 注意：编码与解码使用的字符集须一致。
 * @date 2023/7/24 21:21
 */
public class StringTest1 {
    @Test
    public void test3(){
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));

        String str2 = new String(bytes);
        System.out.println(str2);
    }

    @Test
    public void test2(){
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    @Test
    public void test1(){
        String str1 = "123";
        int num  = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num + "";


    }
}
