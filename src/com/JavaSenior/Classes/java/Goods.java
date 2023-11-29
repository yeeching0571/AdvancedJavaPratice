package com.JavaSenior.Classes.java;

/**
 * @author yeeching
 * @version 1.0
 * @description:TODO
 * @date 2023/8/3 14:43
 */
public class Goods implements Comparable{
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return "Goods{" +
                "name = '" + name + '\'' +
                "price = " + price +
                '}';
    }

    @Override
    public int compareTo(Object o){
        if (o instanceof Goods){
            Goods goods = (Goods)o;
            //商品比较方式，按价格从低到高，再按名称从高到低
            //方式一
            if (this.price > goods.price){
                return 1;
            }else if (this.price < goods.price){
                return -1;
            }else {
                return -this.name.compareTo(goods.name);
            }
            //方式二
//            Double.compare(this.price, goods.price);
        }else {
            throw new RuntimeException("传入的数据类型不一致！");
        }
    }
}
