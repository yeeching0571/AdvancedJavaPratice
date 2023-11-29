package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.*;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * 一、集合框架的概述
 * 1. 集合、数组都是对多个数据进行存储操作的结构，简称 Java 容器。
 *    说明：此时的村你出，主要值得是内存层面的存储，不涉及持久化的存储（.txt, .jpg, .avi, 数据库中存储）
 *
 * 2. 数据在存储多个数据方面的特点：
 *      一旦初始化，其长度就不可修改
 *      一旦定义好，其元素类型也就确定了。比如：String[] arr1; Object[] arr2;
 *      数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便。
 *      获取数组中实际元素个数的需求，数组没有现成的属性或方法可用
 *      不能满足存储无序、不可重复的数据需求
 *
 * 二、集合框架
 *      |----Collection 接口：单列集合，可以用来存储一个个的对象
 *          |----List 接口：存储有序的可重复的数据。 ---> “动态” 数组
 *              |---- ArrayList、LinkedList、Vector
 *          |----Set 接口：存储无序的、不可重复的数据。 --->高中讲的 "集合“
 *              |---- HashSet、LinkedHashSet、TreeSet
 *
 *      |----Map 接口：双列集合，用来存储一对 (key - value) 数据。 --->高中函数：y = f(x)
 *              |---- HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * 三、Collection 接口中的方法
 *
 *  add()、size()、addAll()、clear()、isEmpty()、contains()、containsAll()、
 *  remove()、removeAll()、retainAll()、equals()、hashCode()、toArray()
 *
 * 向 Collection 接口的实现类对象中添加 obj 时， 要求 obj 所在类要重写 equals()
 *
 * 四、遍历 Collection 的两种方式：
 *  1)使用迭代器 Iterator
 *  2)foreach循环（增强 for 循环）
 *
 * @date 2023/8/7 17:01
 */
public class CollectionTest {

    //add()、size()、addAll()、clear()、isEmpty()
    @Test
    public void test1(){
        Collection coll1 = new ArrayList();
        //add(Object e)， 将元素 e 添加到集合中
        coll1.add("AA");
        coll1.add("BB");
        coll1.add(123);//自动装箱
        coll1.add(new Date());

        //size()
        System.out.println(coll1.size());

        //addAll(Collection coll1): 将 coll1 集合中的所有元素添加到当前集合中
        Collection coll2 = new ArrayList();
        coll2.add(345);
        coll2.add("CC");
        coll2.addAll(coll1);
        System.out.println(coll2.size());

        //clear(): 清空集合元素
        coll1.clear();

        //isEmpty(): 判断当前集合是否为空
        System.out.println(coll1.isEmpty());
    }

    //contains()、containsAll()、remove()、removeAll()、retainAll()、equals()
    @Test
    public void test2(){
        Collection coll1 = new ArrayList();
        coll1.add("AA");
        coll1.add(new String("BB"));
        coll1.add(123);//自动装箱
        coll1.add(new Date());
        coll1.add(new Person("Tom", 20));

        //contains(Object obj): 判断当前集合是否包含 obj
        boolean contains = coll1.contains(123);
        System.out.println(contains);
        System.out.println(coll1.contains(new Person("Tom", 20)));

        //containsAll(Collection coll1): 判断 coll1 中的所有元素是否都存在于当前集合中
        Collection coll2 = Arrays.asList(123,"AA");
        System.out.println(coll1.containsAll(coll2));

        //remove(Object obj): 从当前集合中移除 obj 元素， 需要重写 obj 类的 equals() 方法。
        System.out.println(coll1);
        coll1.remove("BB");
        coll1.remove(new Person("Tom", 20));
        System.out.println(coll1);

        //removeAll(Collection coll1): 从当前集合中移除 coll1 中的元素
        coll1.removeAll(coll2);
        System.out.println(coll1);

        //retainAll(Collection coll1): 获取当前集合与 coll1 集合的交集，并返回当前集合
        coll1.add(123);
        coll1.add("AA");
        coll2.retainAll(coll1);
        System.out.println(coll2);

        //equals(Object obj): 要想返回 true，当前集合与形参集合元素相等
        Collection coll3 = new ArrayList();
        coll3.add(123);
        coll3.add("ABC");
        Collection coll4 = new ArrayList();
        coll4.add(123);
        coll4.add("ABC");
        System.out.println(coll3.equals(coll4));
    }

    //hashCode()、toArray()
    @Test
    public void test3(){
        Collection coll1 = new ArrayList();
        coll1.add("AA");
        coll1.add("BB");
        coll1.add(123);//自动装箱
        coll1.add(new Date());

        //hashCode(): 返回当前对象的哈希值
        System.out.println(coll1.hashCode());

        //toArray(): 集合 ---> 数组
        Object[] arr = coll1.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //拓展：数组 ---> 集合：调用 Arrays 类的静态方法 asList()
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        //注意 int[] 和 Integer[] 区别
        List list1 = Arrays.asList(new int[]{123, 456});
        System.out.println(list1.size()); // 1
        List<Integer> list2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(list2.size()); // 2

        // foreach 遍历
        list2.forEach(System.out::println);

        //iterator(): 返回 Iterator 接口的实例，用于遍历集合元素。放在 IteratorTest.java 中
    }

}
