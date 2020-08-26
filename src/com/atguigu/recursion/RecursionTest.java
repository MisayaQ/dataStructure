package com.atguigu.recursion;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-08-25 16:05
 **/
public class RecursionTest {
    public static void main(String[] args) {
        //通过打印问题 回顾递归的调用机制
        test(4);

        //int res = factorial(3);
        //System.out.println("res=" + res);  //6
    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        } //else {
        System.out.println("n=" + n);
        // }
    }

    //阶乘问题
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n -1) * n; // 1 * 2 * 3
        }
    }
}

