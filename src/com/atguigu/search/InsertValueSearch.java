package com.atguigu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-12-08 21:24
 **/
public class InsertValueSearch {
    public static void main(String[] args) {

//		int [] arr = new int[100];
//		for(int i = 0; i < 100; i++) {
//			arr[i] = i + 1;
//		}

        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
//
        List<Integer> list = insertValueSearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
//        //int index = binarySearch(arr, 0, arr.length, 1);
//        System.out.println("index = " + index);

        System.out.println(Arrays.toString(arr));
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        System.out.println("二分查找被调用~");
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) { // 向 右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {

            return mid;
        }

    }


    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {

        System.out.println("插值查找次数~~");

        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }

        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 说明向左递归查找
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }

    }


    //编写插值查找算法
    //说明：插值查找算法，也要求数组是有序的
    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 查找值
     * @return 如果找到，就返回对应的下标，如果没有找到，返回-1
     */
    public static List<Integer> insertValueSearch2(int[] arr, int left, int right, int findVal) {
        //注意：findVal < arr[0]  和  findVal > arr[arr.length - 1] 必须需要
        //否则我们得到的 mid 可能越界
        if (left > right|| findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return new ArrayList<>();
        }
        // 求出mid, 自适应
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) { // 说明应该向右边递归
            return insertValueSearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insertValueSearch2(arr, left, mid - 1, findVal);
        } else {
            List<Integer> resIndexList = new ArrayList<>();
            resIndexList.add(mid);
            int temp = mid - 1;
            while (true) {
                if ((temp < 0 || arr[temp] != findVal)) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;
            }
            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }

}
