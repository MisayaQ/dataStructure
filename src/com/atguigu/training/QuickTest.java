package com.atguigu.training;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 快速排序-填坑
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-10-13 15:39
 **/
public class QuickTest {
    public static void main(String[] args) {
        int[] arr = {-9,78,0,23,-567,70, -1,900, 4561};
        quickSprt(arr, 0, arr.length - 1);
        System.out.println("arr=" + Arrays.toString(arr));
    }
    public static void quickSprt(int[] array,int low,int high){
        if(low>=high) return;
        int left = low;
        int right = high;
        int pivot = array[left];//设立基准点
        while (left<right){
            while (left<right && array[right]>pivot)//从右向左，大数位置不变
                right--;
            array[left] = array[right];//把小数移到左边

            while (left < right && array[left]<pivot) //从左向右，小数位置不变
                left++;
            array[right] = array[left];//把大数移到右边

        }

        array[left]=pivot;
        quickSprt(array,low,left-1);
        quickSprt(array,left+1,high);

    }
}
