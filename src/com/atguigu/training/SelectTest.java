package com.atguigu.training;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-10-07 09:30
 **/
public class SelectTest {
    public static void main(String[] args) {
        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);

    }
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//第一层循环是为了遍历素有的元素
            int minIndex = i;//假定i就是当前最小值的索引
            int min = arr[i];//min用来存放最小值
            for (int j = i + 1; j < arr.length; j++) {//第二层循环是为了从第一层的下一个元素开始逐个比较
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 将最小值，放在arr[0], 即交换 ----> 优化
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
    }

}
