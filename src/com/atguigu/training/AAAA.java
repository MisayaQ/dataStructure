package com.atguigu.training;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-10-30 10:07
 **/
public class AAAA {
    private String name;

    public AAAA() {
    }

    public AAAA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AAAA{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        AAAA aaaa = new AAAA("123");
        AAAA bbb = null;
        bbb = aaaa;
        bbb.setName("321");
        System.out.println(aaaa);
        System.out.println(bbb);
    }
}
