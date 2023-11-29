package com.JavaSenior.Classes.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yeeching
 * @version 1.0
 * @description: 对象比较方法
 * 一、说明：Java 中的对象，正常情况下，只能进行比较： == 或 != .不能使用 > 或 < 。
 *         但是在开发场景中，我们需要比较对象的大小。如何实现？ 使用 Comparable 或 Comparator 接口。
 *
 * 二、Comparable 接口使用举例：自然排序
 *  1. String 包装类等实现类 Comparable 接口，重写了 compareTo(obj) 方法，实现从小到大排序功能。
 *  2. 重写 compareTo(obj) 规则：
 *    当前对象 this 大于形参对象 obj，返回正数，
 *                小于形参对象 obj，返回负数，
 *                等于形参对象 obj，返回零。
 *  3. 对于自定义类来说，可以通过实现 Comparable 接口并重写 compareTo(obj) 方法来实现排序功能。
 *
 * 三、Comparator 接口的使用：定制排序
 *  1. 背景
 *      当元素的类型没有实现 java.lang.Comparable 接口而又不方便修改代码，
 *      或者实现了 java.lang.Comparable 接口的排序规则不适合当前操作，
 *      那么可以考虑使用 Comparator 的对象来排序。
 *  2. 重写 compare(Object o1,Object o2) 方法，比较o1和o2的大小：
 *      如果方法返回正整数，则表示o1大于o2；
 *      如果返回0，表示相等；
 *      返回负整数，表示o1小于o2。
 *
 * 四、Comparable 接口与 Comparator 的使用对比
 *      Comparable 接口的方式一旦指定，保证 Comparable 接口实现类的对象在任何位置都可以比较大小。
 *      Comparator 接口属于临时性的比较。
 * @date 2023/8/3 11:59
 */
public class CompareTest {

    // String 类实现了 Comparable 接口
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","DD","KK","EE","CC","BB"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        Goods[] goods = new Goods[5];
        goods[0] = new Goods("LenoveMouse", 30);
        goods[1] = new Goods("XiaomiMouse", 23);
        goods[2] = new Goods("AppleMouse", 53);
        goods[3] = new Goods("LogicMouse", 27);
        goods[4] = new Goods("HuaweiMouse", 30);

        Arrays.sort(goods);
        System.out.println(Arrays.toString(goods));
    }

    @Test
    public void test3(){
        String[] arr = new String[]{"AA","DD","KK","EE","CC","BB"};
        Arrays.sort(arr, new Comparator<String>() {

            //按照字符串从大到小排序
            @Override
            public int compare(String o1, String o2) {
                if( o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
