package com.module1;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * @date 2023/12/27 14:10
 */
public class Person {
    public int age;
    private String name;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public void show(){
        System.out.println("Hello ");
    }

    private String showNationality(String nation){
        System.out.println("My nationality is " + nation);
        return nation;
    }
}
