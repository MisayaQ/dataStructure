package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-09-01 22:44
 **/
public class SelectSort {
    public static void main(String[] args) {
//        int [] arr = {101, 34, 119, 1, -1, 90, 123};
//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        long startTime=System.currentTimeMillis();   //获取开始时间

        selectSort(arr);

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)/1000+"s");

//        System.out.println("排序后");
//        System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
        //在推导的过程，我们发现了规律，因此，可以使用for来解决
        //选择排序时间复杂度是 O(n^2)
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//假定i就是当前最小值索引
            int min = arr[i];//假定当前arr[i]就是最小的
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) { // 说明假定的最小值，并不是最小
                    min = arr[j]; // 重置min
                    minIndex = j; // 重置minIndex
                }
            }

            // 将最小值，放在arr[0], 即交换 ----> 优化
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

//            System.out.println("第"+(i+1)+"轮后~~");
//            System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }

        //使用逐步推导的方式来，讲解选择排序
        //第1轮
        //原始的数组 ： 	101, 34, 119, 1
        //第一轮排序 :   	1, 34, 119, 101
        //算法 先简单--》 再复杂， 就是可以把一个复杂的算法，拆分成简单的问题-》逐步解决
        /*int minIndex = 0;
        int min = arr[0];
        for (int j = 0 + 1; j < arr.length; j++) {
            if (min > arr[j]) { //说明假定的最小值 并不是最小的
                min = arr[j];//重置min
                minIndex = j;//重置minIndex
            }
        }
        //将最小值 放在arr[0]的位置 即交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第1轮后~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 119, 101

        //第2轮=
        minIndex = 1;
        min = arr[1];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) { // 说明假定的最小值，并不是最小
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }
        // 将最小值，放在arr[0], 即交换
        if(minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第2轮后~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 119, 101

        //第3轮
        minIndex = 2;
        min = arr[2];
        for (int j = 2 + 1; j < arr.length; j++) {
            if (min > arr[j]) { // 说明假定的最小值，并不是最小
                min = arr[j]; // 重置min
                minIndex = j; // 重置minIndex
            }
        }

        // 将最小值，放在arr[0], 即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }

        System.out.println("第3轮后~~");
        System.out.println(Arrays.toString(arr));// 1, 34, 101, 119*/

    }
}
