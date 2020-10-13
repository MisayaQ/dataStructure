package com.atguigu.training;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-10-07 09:13
 **/
public class BubbleTest {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};
        int temp = 0;
        boolean flag = false;//标识变量 表示是否进行交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;//如果发生了交换 将flag置为true 记得后面进行恢复为false
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {//在一次排序中 一次交换都没有发生过 说明排序完成
                break;
            } else {
                flag = false;//重置flag进行下次的判断
            }
            System.out.println("第"+(i+1)+"趟排序后的数组：");
            System.out.println(Arrays.toString(arr));
        }


    }
}
