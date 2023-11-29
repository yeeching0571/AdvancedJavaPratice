package com.JavaSenior.Classes.java;

import org.junit.Test;

/**
 * @author yeeching
 * @version 1.0
 * @description: String 常见方法
 * 1. int length()：返回字符串的长度： return value.length
 * 2. char charAt(int index)： 返回某索引处的字符return value[index]
 * 3. boolean isEmpty()：判断是否是空字符串：return value.length == 0
 * 4. String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写
 * 5. String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写
 * 6. String trim()：返回字符串的副本，忽略前导空白和尾部空白
 * 7. boolean equals(Object obj)：比较字符串的内容是否相同
 * 8. boolean equalsIgnoreCase(String anotherString)：与 equals 方法类似，忽略大小写
 * 9. String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用 “+”
 * 10. int compareTo(String anotherString)：比较两个字符串的大小
 * 11. String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从 beginIndex 开始截取到最后的一个子字符串。
 * 12. String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从  beginIndex 开始截取到endIndex(不包含)的一个子字符串。
 * 13. boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束
 * 14. boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始
 * 15 boolean startsWith(String prefix, int toffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始
 * 16 boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true
 * 17 int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引
 * 18 int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始
 * 19 int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引
 * 20 int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
 * 注：indexOf和lastIndexOf方法如果未找到都是返回-1
 * 21 String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 * 22 String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。
 * 23 String replaceAll(String regex, String replacement) ： 使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。
 * 24 String replaceFirst(String regex, String replacement) ： 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
 * 25 boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
 * 26 String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。
 * 27 String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
 * @date 2023/7/24 16:46
 */
public class StringMethodsTest {
    @Test
    public void test4(){
        String s1 = "柚香奇兰柚香奇兰";
        String s2 = s1.replace("柚香", "白芽");
        System.out.println(s1);
        System.out.println(s2);

        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);
    }

    @Test
    public void test3(){
        String s1 = "helloworld";
        boolean b1 = s1.endsWith("world");
        System.out.println(b1);

        boolean b2 = s1.startsWith("hello");
        System.out.println(b2);

        boolean b3 = s1.startsWith("el", 1);
        System.out.println(b3);

        boolean b4 = s1.contains("owo");
        System.out.println(b4);

        System.out.println(s1.indexOf("lo"));
        System.out.println(s1.indexOf("lo", 5));
        System.out.println(s1.indexOf("lol"));

        String s2 = "HellorWorld";
        System.out.println(s2.lastIndexOf("or"));
        System.out.println(s2.lastIndexOf("or",6));

    }

    @Test
    public void test2(){
        String s1 = "hello world";
        String s2 = "Hello world";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = "abe";
        System.out.println(s3.compareTo(s4));

        String s5 = "柚香奇兰比碧潭飘雪好喝！！！";
        System.out.println(s5.substring(5));
        System.out.println(s5.substring(0,4));
    }


    @Test
    public void test1(){
        String s1 = "Hello world";
        System.out.println(s1.charAt(1));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());

        String s3 = "   he llo  world  ";
        String s4 = s3.trim();
        System.out.println("-----"+ s3 +"-----");
        System.out.println("-----"+ s4 +"-----");
    }

}
