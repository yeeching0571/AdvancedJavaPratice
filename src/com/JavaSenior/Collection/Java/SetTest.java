package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 *
 * 1. Set 接口中没有额外定义新的方法，使用的都是 Collection 中声明过得方法。
 * 2. 要求：向 Set 中添加的数据，其所在的类一定要重写 hashCode() 和 equals()
 *    要求：重写的 hashCode() 和 equals() 尽可能保持一致性：相等的对象必须具有相等的散列码
 *
 * 一、Set 接口：存储无序、不可重复的数据。
 * HashSet: 作为 Set 接口的主要实现类；线程不安全的；可以存储 null 值。
 * LinkedHashSet: 作为 HashSet 的子类；在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个
 *                数据。对于频繁的遍历操作，LinkedHashSet 效率高于 HashSet.
 * TreeSet：可以按照添加对象的指定属性，进行排序。
 *
 * 以 HashSet 为例说明：
 * 1. 无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值。
 * 2. 不可重复性：保证添加的元素按照 equals() 判断时，不能返回 true。即，相同的元素只能添加一个。
 *
 * 二、添加元素的过程：以 HashSet 为例：
 *  向 HashSet 中添加元素 a，首先调用元素 a 所在类的 hashCode() 方法，计算元素 a 的哈希值，
 *  根据此哈希值通过某种算法计算出元素 a 在 HashSet 底层数组中的存放位置（即索引位置），判断
 *  数组在此位置上是否有元素：
 *      如果此位置上没有其它元素，则添加元素 a 成功。   ---> 情况 1
 *      如果此位置上有其它元素 b（或者以链表形式存在的多个元素），则比较元素 a 与元素 b 的 hash 值：
 *          如果 hash 值不相同，则添加元素 a 成功。  ---> 情况 2
 *          如果 hash 值相同，进而调用元素 a 所在类的 equals() 方法：
 *              equals() 返回 true，添加元素 a 失败。
 *              equals() 返回 false，添加元素 a 成功。  ---> 情况 3
 *
 *  对于添加成功的情况 2 和情况 3 而言：元素 a 与已经存在指定索引位置上的数据以链表方式存储。
 *  JDk 7: 元素 a 放到数组中，指向原来的元素
 *  JDK 8: 原来的元素在数组中，指向元素 a
 *  详情见 doc/HashSet.jpg
 *
 *
 * @date 2023/8/8 20:25
 */
public class SetTest {
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add("AA");
        set.add("BB");
        set.add(123);
        set.add(123);
        set.add(456);
        set.add(new Person("Tom", 20));
        set.add(new Person("Tom", 20));
        System.out.println(set);
    }

    // LinkedHashSet 作为 HashSet 的子类，
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add("AA");
        set.add("BB");
        set.add(123);
        set.add(123);
        set.add(456);
        set.add(new Person("Tom", 20));
        set.add(new Person("Tom", 20));
        System.out.println(set);
    }
}
