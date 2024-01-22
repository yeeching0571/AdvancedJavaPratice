package com.JavaSenior.Updates;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * @date 2023/12/30 15:31
 */
public class Girl {

    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
