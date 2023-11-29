package com.JavaSenior.Classes.exercise;

import org.junit.Test;

/**
 * @author yeeching
 * @version 1.0
 * @description: 获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数。
 * @date 2023/7/31 16:29
 */
public class SubstringCount {
    //方法1
    public int getCount(String mainStr, String subStr){
        int count = 0;
        if (mainStr != "" && subStr != ""){
            while (true){
                if (mainStr.contains(subStr)){ //mainStr.indexOf(subStr) != -1
                    count++;
                    int index = mainStr.indexOf(subStr) + subStr.length();
                    mainStr = mainStr.substring(index);
                }else {
                    break;
                }
            }
        }
        return count;
    }
    //方法2 效率更高
    public int getCount1(String mainStr, String subStr){
        int count = 0;
        int index = 0;
        if (mainStr.length() >= subStr.length()){
            while ((index = mainStr.indexOf(subStr, index)) != -1){
                count++;
                index += subStr.length();
            }
            return count;
        }
        return 0;
    }
    @Test
    public void getCountTest(){
        int count = getCount1("abkkcadkabkebfkabkskab","ab");
        System.out.println(count);
    }
}
