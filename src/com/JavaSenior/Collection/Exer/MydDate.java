package com.JavaSenior.Collection.Exer;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 *
 * @date 2023/8/11 10:43
 */
public class MydDate {
    private int year;
    private int month;
    private int day;

    public MydDate() {
    }

    public MydDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MydDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
