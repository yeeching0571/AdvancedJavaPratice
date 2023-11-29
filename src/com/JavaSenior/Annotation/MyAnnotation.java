package com.JavaSenior.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 * 一、如何自定义注解：参照 @SuppressWarnings 定义
     * 1) 注解声明为 @interface
     * 2) 内部定义成员，通常使用 value 表示
     * 3) 可以指定成员的默认值，使用 default 定义
     * 4) 如果自定义注解没有成员，表明是一个标识作用。
 *
 * 如果注解有成员，在使用注解时，需要指明成员的值。
 *
 *  二、JDK 提供的四种元注解（对现有注解进行解释说明的注解）
 *    Retention(常用):  用于指定该 Annotation 的生命周期（ SOURCE、 CLASS(默认)、 RUNTIME ）
 *                只有声明为 RUNTIME 生命周期的注解，才能通过反射获取。
 *    Target(常用): 用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 *    Documented: 用于指定被该元 Annotation 修饰的 Annotation 类将被javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
 *    Inherited: 被它修饰的 Annotation 将具有继承性。
 *
 * @date 2023/8/7 15:51
 */

@Retention(RetentionPolicy.RUNTIME)
//@Target(value = {CONSTRUCTOR, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, TYPE_USE})
public @interface MyAnnotation {
    String value() default "hello";
}
