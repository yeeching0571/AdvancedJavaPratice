package com.JavaSenior.Collection.Exer;

import java.util.Comparator;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * @date 2023/8/11 10:43
 */
public class Employee implements Comparable {
    private String name;
    private int age;
    private MydDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MydDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MydDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MydDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }
        throw new RuntimeException("传入数据类型不一致");
    }
}
