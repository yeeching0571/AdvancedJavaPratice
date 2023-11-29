package com.JavaSenior.Collection.Java;

import org.junit.Test;

import java.util.*;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 *  /---- Map: 双列数据，存储 key-value 对的数据
 *          /---- HashMap: 作为 Map 的主要实现类，线程不安全的，效率高；可存储 null 的 key or value 值
 *              /---- LinkedHashMap: 保证在遍历 map 元素时，可以按照添加的顺序实现遍历
 *                      原因：在原有的 HashMap 底层结构基础上，添加了一对指针 (doubly-linked list)，指向前一个和后一个元素
 *                      对于频繁的遍历操作，此类执行效率高于 HashMap。
 *         /---- TreeMap: 保证按照添加的 key-value pair 进行排序，实现排序遍历。此时考虑 key 的自然排序或定制排序
 *                        底层使用红黑树
 *         /---- HashTable: 作为古老的实现类：线程安全的，效率低；不能存储 null 的 key or value
 *              /---- Properties: 常用来处理配置文件。key 和 value 都是 String 类型
 *
 *
 * Map 结构的理解：
 *  Map 中的 key: 无序的、不可重复的， 使用 Set 存储所有 key  ---> key 所在的类要重写 equals() 和 hashCode() (以 HashMap 为例)
 *  Map 中的 value: 无序的、可重复的， 使用 Collection 存储所有的 value ---> value 所在的类要重写 equals()
 *  一个键值对(key-value)构成了一个 Entry 对象
 *  Map 中的 entry: 无序的，不可重复的， 使用 Set 存储所有的 entry
 *
 *
 * HashMap 的底层实现原理（以 jdk7 为例）
 *  HashMap map = new HashMap():
 *  在实例化以后，底层创建了长度是 16 的一维数组 Entry[] table。
 *
 *  map.put(key1, value1):
 *  首先，调用 key1 所在类的 hashCode() 计算 key1 哈希值，此哈希值经过某种算法计算以后，得到在 Entry 数组中的存放位置。
 *  如果此位置为空，key-value pair 添加成功。 ---- 情况1
 *  如果此位置上数据不为空，（意味着此位置存在一个或多个数据（以链表的形式存在）），比较 key1 和已存在的一个或多个数据的哈希值：
 *      如果 key1 的哈希值与已存在的数据哈希值都不相同，此时 key-value pair 添加成功。 ----情况2
 *      如果 key1 的哈希值与已存在的某个数据 (key2-value2) 的哈希值相同，继续比较：调用 key1 所在类的 equals(key2):
 *          如果 equals() 返回 false: 此时 key1-value1 添加成功。 ---- 情况3
 *          如果 equals() 返回 true: 使用 value1 替换 value2。
 *
 *  补充：关于情况2和情况3：此时 key1-value1 和原来的数据以链表的方式存储。
 *       在不断地添加过程中，会涉及到扩容问题，默认的扩容方式：扩容为原来容量的两倍，并将原有的数据复制过来。
 *
 *  jdk8 相较于 jdk7 在底层实现方面的不同：
 *  1. new HashMap(): 底层没有创建一个长度为 16 的数组
 *  2. jdk8 底层的数据是 Node[], 而非 Entry[]
 *  3. 首次调用 put() 方法时，底层创建长度为 16 的数组
 *  4. jdk7 底层结构只有：数组+链表。jdk8 中底层结构：数组+链表+红黑树。
 *      当数组上某个索引位置上的元素以链表形式存在的数据个数 > 8且当前数组的长度 > 64时，
 *      此时此索引位置上的所有数据改为使用红黑树存储。
 *
 * Map 中涉及的方法
 * 添加、 删除、修改操作：
 *  Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
 *  void putAll(Map m):将m中的所有key-value对存放到当前map中
 *  Object remove(Object key)：移除指定key的key-value对，并返回value
 *  void clear()：清空当前map中的所有数据
 *
 * 元素查询的操作：
 *  Object get(Object key)：获取指定key对应的value
 *  boolean containsKey(Object key)：是否包含指定的key
 *  boolean containsValue(Object value)：是否包含指定的value
 *  int size()：返回map中key-value对的个数
 *  boolean isEmpty()：判断当前map是否为空
 *  boolean equals(Object obj)：判断当前map和参数对象obj是否相等
 *
 * 元视图操作的方法：
 *  Set keySet()：返回所有key构成的Set集合
 *  Collection values()：返回所有value构成的Collection集合
 *  Set entrySet()：返回所有key-value对构成的Set集合
 *
 *
 * @date 2023/11/19 10:37
 */
public class MapTest {
    @Test
    public void test1(){
      /*添加、 删除、修改操作：
      Object put(Object key,Object value)：将指定key-value添加到(或修改)当前map对象中
      void putAll(Map m):将m中的所有key-value对存放到当前map中
      Object remove(Object key)：移除指定key的key-value对，并返回value
      void clear()：清空当前map中的所有数据*/
        Map map = new HashMap();
        //添加
        map.put("A",123);
        map.put("2",123);
        map.put("B",123);
        map.put("bool", true);
        //修改
        map.put("A",456);
        System.out.println(map);

        Map map1 = new HashMap();
        map1.put("3","df");
        map1.put("4","gf");
        map.putAll(map1);
        System.out.println(map);


        //remove
        Object value = map.remove("bool");
        System.out.println(value);
        System.out.println(map);
    }

    @Test
    public void test2(){
        /*  Set keySet()：返回所有key构成的Set集合
            Collection values()：返回所有value构成的Collection集合
            Set entrySet()：返回所有key-value对构成的Set集合 */

        Map map = new HashMap();
        map.put("A","abc");
        map.put("2",222);
        map.put("B","bcd");
        map.put("bool", true);

        // 遍历所有的 key 集， keySet()
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // 遍历所有的 value 集：values()
        Collection coll = map.values();
        for(Object obj: coll){
            System.out.println(obj);
        }

        // 遍历所有的 key-value: entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){

            // 方法一
            Object obj = iterator1.next();
            // entrySet 集合中的元素都是 entry
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey() + " --> " + entry.getValue());

            // 方法二
//            Object key = iterator1.next();
//            Object value = map.get(key);
//            System.out.println(key + "====" + value);
        }

    }


    }

