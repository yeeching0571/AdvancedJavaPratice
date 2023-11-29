package com.JavaSenior.Enum;

/**
 * @author yeeching
 * @version 1.0
 * @description: 使用 enum 关键字定义枚举类
 * 说明：定义的枚举类默认继承于 java.lang.Enum 类
 *
 * Enum 类中的常用方法
 *    1) values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。
 *    2) valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。
 *      如不是，会有运行时异常：IllegalArgumentException。
 *    3) toString()：返回当前枚举类对象常量的名称
 *
 * 使用 Enum 关键字定义的枚举类实现接口的情况
 *   情况一：实现接口，在 enum 类中实现抽象方法
 *   情况二：让枚举类的对象分别实现抽象方法
 * @date 2023/8/4 18:55
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.toString());
        summer.show();

        System.out.println("\n**********************************");
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].toString());
        }

        System.out.println("\n**********************************");
        Season1 autumn = Season1.valueOf("AUTUMN");
        System.out.println(autumn);

    }
}

interface Info{
    void show();
}

enum Season1 implements Info{
    //1.提供当前枚举类的的对象，对象之间用 , 隔开，最后一个用 ; 结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("乱花渐欲迷人眼，浅草才能没马蹄");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("明月别枝惊鹊，清风半夜鸣蝉");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("未觉池塘青草梦，阶前梧叶已秋声");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("日暮苍山远，天寒白屋贫");
        }
    };

    //2. 声明 Season 对象的属性：private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    //3. 私有化类的构造器并给对象属性赋值
     Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //4. 其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }
    @Override
    public String toString(){
        return "SeasonName: " + seasonName + '。' +
                " SeasonDesc: " + seasonDesc + '。';
    }

    //在 enum 类中实现抽象方法
//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}
