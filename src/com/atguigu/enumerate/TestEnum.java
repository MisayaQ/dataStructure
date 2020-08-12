package com.atguigu.enumerate;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: Jia_Q
 * @create: 2020-07-19 17:39
 **/
public class TestEnum {
    public enum Sex{
        male, female;
    }

    public static void main(String[] args) {
        compare(Sex.valueOf("male"));    //比较
    }

    private static void compare(Sex s) {
        for (int i = 0; i < s.values().length; i++) {
            System.out.println(s+"与"+Sex.values()[i]+"的比较结果是："+s.compareTo(Sex.values()[i]));
        }
    }
}
