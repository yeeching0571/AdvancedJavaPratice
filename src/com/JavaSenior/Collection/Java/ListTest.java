package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 *
 * List 接口：存储有序的、可重复的数据。如果存储的是自定义类对象，自定义类需要重写 equals()。
 *
 * ArrayList、LinkedList、Vector 三者的异同？
 * 同：三者都实现了 List 接口；存储数据的特点相同：有序的、可重复的数据
 * 不同：
 *  ArrayList: 作为 List 接口的主要实现类；线程不安全的，效率高；底层使用 Object[] elementData 存储
 *  LinkedList: 对于频繁的插入、删除操作，使用此类效率比 ArrayList 高；底层使用双向链表存储
 *  Vector: 作为 List 古老的实现类；线程安全，效率低；底层使用 Object[] elementData 存储
 *
 * List 接口中的常用方法
 *   void add(int index, Object ele):在 index 位置插入 ele 元素
 *   boolean addAll(int index, Collection eles):从 index 位置开始将 eles 中的所有元素添加进来
 *   Object get(int index):获取指定 index 位置的元素
 *   int indexOf(Object obj):返回 obj 在集合中首次出现的位置。如果不存在，返回 -1 。
 *   int lastIndexOf(Object obj):返回 obj 在当前集合中末次出现的位置
 *   Object remove(int index):移除指定 index 位置的元素，并返回此元素
 *   Object set(int index, Object ele):设置指定 index 位置的元素为 ele
 *   List subList(int fromIndex, int toIndex):返回从 fromIndex 到 toIndex 位置的子集合
 * @date 2023/8/8 16:38
 */
public class ListTest {

    @Test
    public void test1(){
        ArrayList list1 = new ArrayList();
        list1.add("AA");
        list1.add("BB");
        list1.add(123);
        list1.add(101112);
        list1.add(new Person("Tom", 20));
        System.out.println(list1);

        // void add(int index, Object ele)
        list1.add(2, "CC");
        System.out.println(list1);

        // boolean addAll(int index, Collection eles)
        List list2 = Arrays.asList(456, 789);
        list1.addAll(4, list2);
        System.out.println(list1);

        //Object get(int index)
        System.out.println(list1.get(3));
    }
}
