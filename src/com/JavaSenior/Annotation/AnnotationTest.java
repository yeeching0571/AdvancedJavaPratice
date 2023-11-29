package com.JavaSenior.Annotation;

import java.util.ArrayList;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * 1. 理解 Annotation
 *  ① JDK5.0 新增功能
 *  ② 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。通过使用 Annotation,
 *  程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 *  ③ 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，
 *  例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。
 *
 * 2. Annotation 使用示例
 *  示例一：生成文档相关的注解
 *  示例二：在编译时进行格式检查（JDK 内置的三个基本注解）
 *      @Override: 限定重写父类方法, 该注解只能用于方法
 *      @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 *      @SuppressWarnings: 抑制编译器警告
 *
 * 3. 如何自定义注解：参照 @SuppressWarnings 定义
 *      ① 注解声明为 @interface
 *      ② 内部定义成员，通常使用 value 表示
 *      ③ 可以指定成员的默认值，使用 default 定义
 *      ④ 如果自定义注解没有成员，表明是一个标识作用。
 *
 *    如果注解有成员，在使用注解时，需要指明成员的值.
 *    自定义注解必须配上注解的信息处理流程（使用反射）才有意义
 *
 * 4. JDK 提供的四种元注解（对现有注解进行解释说明的注解）
 *   Retention(常用):  用于指定该 Annotation 的生命周期（ SOURCE、 CLASS(默认)、 RUNTIME ）
 *               只有声明为 RUNTIME 生命周期的注解，才能通过反射获取。
 *   Target(常用): 用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 *   Documented: 用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
 *   Inherited: 被它修饰的 Annotation 将具有继承性。
 *
 * @date 2023/8/7 15:28
 */
public class AnnotationTest {

    @SuppressWarnings("unused")
    int num = 10;

    @SuppressWarnings({"unused", "rawtypes"})
    ArrayList list = new ArrayList();
}

@MyAnnotation()
class Person{
    private String name;
    private int age;
    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }
}

class Student extends Person{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }
}


