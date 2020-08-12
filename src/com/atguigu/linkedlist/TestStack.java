package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-08-10 23:36
 **/
//栈的基本使用
public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        // 入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        // 出栈
        // smith, tom , jack
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }
    }
}
