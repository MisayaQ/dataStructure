package com.atguigu.training;

/**
 * @program: dataStructure
 * @description: 快速排序-填坑
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-10-13 15:39
 **/
public class QuickTest {
    public static void main(String[] args) {

    }
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // 递归结束条件：startIndex大等于endIndex的时候
        if (startIndex >= endIndex) {
            return;
        }
        //得到基准元素位置
//        int
    }
/*    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取到第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //填坑的位置
        int index = startIndex;
        //大循环在左右指针重合或者交错时结束
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < pivot) {

                }
            }
        }

    }*/
}
