package com.JavaSenior.Classes.exercise;

import org.junit.Test;

/**
 * @author yeeching
 * @version 1.0
 * @description: 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”
 * @date 2023/7/27 18:48
 */
public class StringReverse {

    //方法一：转换为 char[]
    public String reverse (String str, int start, int end){
        if (str != null){
            char[] arr = str.toCharArray();
            for (int x = start, y = end; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用拼接
    public String reverse1(String str, int start, int end){
        if(str != null){
            String reverseStr = str.substring(0,start);
            for (int i = end; i >= start; i--) {
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(end + 1);
            return reverseStr;
        }
        return null;
    }

    //方式三：使用 StringBuffer/StringBuilder 替换 String
    public String reverse2(String str, int start, int end){
        if (str != null){
            StringBuilder strb = new StringBuilder(str.substring(0,start));
            for (int i = end; i >= start; i--){
                strb.append(str.charAt(i));
            }
            strb.append(str.substring(end + 1));
            return strb.toString();
        }
        return null;
    }
    @Test
    public void testReverse2(){
        String str = "abcdefg";
        String reverse = reverse2(str, 2, 5);
        System.out.println(reverse);
    }
}

