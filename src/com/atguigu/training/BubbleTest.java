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
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
