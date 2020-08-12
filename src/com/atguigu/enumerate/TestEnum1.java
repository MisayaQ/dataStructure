package com.atguigu.enumerate;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: Jia_Q
 * @create: 2020-07-19 18:24
 **/
public class TestEnum1 {
    enum Singnal{
        //定义一个枚举类型
        GREEN,YELLOW,RED;
    }

    public static void main(String[] args) {
        for(int i=0;i<Signal.values().length;i++)
        {
            System.out.println("索引"+Signal.values()[i].ordinal()+"，值："+Signal.values()[i]);
        }
    }
}
