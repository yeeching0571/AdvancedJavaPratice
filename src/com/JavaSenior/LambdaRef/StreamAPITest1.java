package com.JavaSenior.Updates;

import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * Stream 的中间操作
 * 1.筛选与切片
 *  filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
 *  distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
 *  limit(long maxSize) 截断流，使其元素不超过给定数量
 *  skip(long n) 跳过元素，返回一个扔掉了前 个空流。与 limit(n) 互补 n 个元素的流。若流中元素不足 n 个，则返回一
 *
 * 2.映射
 * map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 * mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
 * mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 IntStream。
 * mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元 素上，产生一个新的 LongStream。
 * flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 *
 * 3.排序
 *  sorted() 产生一个新流，其中按自然顺序排序
 *  sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
 *
 * @date 2023/12/29 21:19
 */
public class StreamAPITest1 {

    //1.筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();

        // filter(Predicate p) 接收 Lambda ， 从流中排除某些元素
        Stream<Employee> stream = list.stream();
        // 练习，查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
        System.out.println();

        // limit(long maxSize) 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();

        // skip(long n) 跳过元素，返回一个扔掉了前 n 个空流。与 limit(n) 互补 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        list.stream().skip(7).forEach(System.out::println);
        System.out.println();

        // distinct() 筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
        list.add(new Employee(1010, "刘强东",40, 8000));
        list.add(new Employee(1010, "刘强东",40, 8000));
        list.add(new Employee(1010, "刘强东",41, 8000));

        list.stream().distinct().forEach(System.out::println);
    }

    //2.映射
    @Test
    public void test2(){

        // map(Function f) 接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。如果某个元素是一个流，则将流作为整体处理。相当于list1.add([1,2,3])
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        System.out.println();

        // 练习1：获取员工姓名长度大于3的员工的姓名。
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameString = employees.stream().map(Employee::getName);
        nameString.filter(name -> name.length() >3).forEach(System.out::println);

        System.out.println();

        // 练习2：
        System.out.println("**************map()****************");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });

        // flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。如果某个元素是一个流，则将分解再处理。相当于list1.addAll([1,2,3])
        System.out.println("**************flatMap()****************");
        list.stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::println);

        // mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
        // mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
        // mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。

    }

    // 以list.add() 和list.addAll() 的关系类比 map() 和 flatMap()的关系
    @Test
    public void test3(){
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);

    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str) {//aa
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //3.排序
    @Test
    public void test4(){
        // sorted() 产生一个新流，其中按自然顺序排序
        List<Integer> list = Arrays.asList(12, 32, 0, 7, 64, 9, 54, -32);
        list.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com) 产生一个新流，其中按比较器顺序排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1, e2) -> {
            int ageDiff = Integer.compare(e1.getAge(), e2.getAge());
            if (ageDiff != 0) {
                return ageDiff;
            }else {
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }

}
