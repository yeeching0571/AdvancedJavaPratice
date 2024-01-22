package com.JavaSenior.Updates;

/**
 * @author Yijing He
 * @version 1.0
 * @description:
 * @date 2023/12/30 15:29
 */
public class Boy {

    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}
