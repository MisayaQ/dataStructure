package com.atguigu.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-08-31 22:11
 **/
public class BubbleSort {
    public static void main(String[] args) {
        //冒泡排序的时间复杂度：O(n^2)
//        int arr[] = {3, 9, -1, 10, 20};

        //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }
        long startTime=System.currentTimeMillis();   //获取开始时间


//        System.out.println("排序前");
//        System.out.println(Arrays.toString(arr));
        //测试冒泡排序
        bubbleSort(arr);
//        System.out.println("排序后");
////        System.out.println(Arrays.toString(arr));

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)/1000+"s");

       /* //第二趟排序就是将第二大的数排在倒数第二位
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第二趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第三趟排序，就是将第三大的数排在倒数第三位
        for (int j = 0; j < arr.length - 1 - 2; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第三趟排序后的数组");
        System.out.println(Arrays.toString(arr));

        // 第四趟排序，就是将第4大的数排在倒数第4位
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            // 如果前面的数比后面的数大，则交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println("第四趟排序后的数组");
        System.out.println(Arrays.toString(arr));*/

    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;//临时变量
        boolean flag = false;//标识变量 表示是否进行交换
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组：");
            //System.out.println(Arrays.toString(arr));

            if (!flag) {//在一次排序中 一次交换都没有发生过
                break;
            } else {
                flag = false;//重置flag进行下次的判断
            }
        }
    }
}
