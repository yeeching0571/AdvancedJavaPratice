package com.JavaSenior.Classes.exercise;

import org.junit.Test;

/**
 * @author yeeching
 * @version 1.0
 * @description: 获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"。
 * @date 2023/7/31 17:03
 */
public class MaxSubstring {
    public String getMaxSubstring(String str1, String str2){
        String shortStr = (str1.length() < str2.length()) ? str1 : str2;
        String longStr = (str1.length() >= str2.length()) ? str1 : str2;
        int length = shortStr.length();
        for (int i = 0; i < length; i++) {
            for (int x = 0, y = length -i; y <= length; x++, y++){
                String subStr = shortStr.substring(x, y);
                if (longStr.contains(subStr)){
                    return subStr;
                }
            }

        }
        return null;
    }

    @Test
    public void getMaxSubstringTest(){
        String str = getMaxSubstring("abcwerthelloyuiodef","cvhellobnm");
        System.out.println(str);
    }
}
