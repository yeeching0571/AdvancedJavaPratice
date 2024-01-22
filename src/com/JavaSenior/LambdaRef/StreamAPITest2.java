package com.JavaSenior.Updates;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 *
 * 测试Stream的终止操作
 *
 * 1.匹配与查找
 *  allMatch(Predicate p) 检查是否匹配所有元素
 *  anyMatch(Predicate p) 检查是否至少匹配一个元素
 *  noneMatch(Predicate p) 检查是否没有匹配所有元素
 *  findFirst() 返回第一个元素
 *  findAny() 返回当前流中的任意元素
 *  count() 返回流中元素总数
 *  max(Comparator c) 返回流中最大值
 *  min(Comparator c) 返回流中最小值
 *  forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反， Stream API 使用内部迭代——它帮你把迭代做了)
 *
 * 2.归约
 *  reduce(T identity, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
 *  reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
 *
 * 3.收集
 *  collect(Collector c) 将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
 *
 * @date 2023/12/30 9:30
 */
public class StreamAPITest2 {

    // 1.匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        // allMatch(Predicate p) 检查是否匹配所有元素
        //练习：是否所有员工的年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println("age over 18? "+ allMatch);

        // anyMatch(Predicate p) 检查是否至少匹配一个元素
        //练习：是否存在员工工资大于1000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println("exist salary over 10000? " + anyMatch);

        // noneMatch(Predicate p) 检查是否没有匹配所有元素
        //练习：是否存在员工姓雷
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().contains("雷"));
        System.out.println("exist last name including '雷'? " + noneMatch);

        // findFirst() 返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println("first element: " + first);
        // findAny() 返回当前流中的任意元素

        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println("find any element: " + any);
        // count() 返回流中元素总数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println("count: " + count);
        // max(Comparator c) 返回流中最大值
        //练习：返回最高工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> maxSalary = salaryStream.max(Double::compare);
        System.out.println("maximum salary: " + maxSalary);

        // min(Comparator c) 返回流中最小值
        //练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("employee with minimum salary: " + min);
        System.out.println();

        // forEach(Consumer c) 内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反， Stream API 使用内部迭代——它帮你把迭代做了)
        employees.stream().forEach(System.out::println);
        //使用集合的遍历操作
        employees.forEach(System.out::println);
    }

    // 2.归约
    @Test
    public void test2(){

        // reduce(T identity, BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 T
        //练习：计算1-10的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // reduce(BinaryOperator b) 可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        //练习2：计算公司所有员工工资的综合
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Double> sumSalary = salaryStream.reduce(Double::sum);
        System.out.println("sum salary: " + sumSalary);
    }

    // 3.收集
    @Test
    public void test3(){

        // collect(Collector c) 将流转换为其他形式。接收一个 Collector 接口的实现，用于给Stream中元素做汇总的方法
        //练习1：查找工资大于6000的员工，结果返回为一个 List 或 Set


        List<Employee> employees = EmployeeData.getEmployees();

        //返回为 List
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println();

        //返回为Set
        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }
}
