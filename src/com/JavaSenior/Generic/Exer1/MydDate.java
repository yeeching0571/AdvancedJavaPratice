package com.JavaSenior.Generic.Exer1;

/**
 * @author yeeching
 * @version 1.0
 * @description:
 *
 * @date 2023/8/11 10:43
 */
public class MydDate implements Comparable<MydDate>{
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

    @Override
    public int compareTo(MydDate o) {
        //比较年
        int minusYear = this.getYear() - o.getYear();
        if (minusYear != 0){
            return minusYear;
        }

        //比较月
        int minusMonth = this.getMonth() - o.getMonth();
        if(minusMonth != 0){
            return minusMonth;
        }

        //比较日
        int minusDay = this.getDay() - o.getDay();
        if(minusDay != 0){
            return minusDay;
        }
        return 0;
    }
}
