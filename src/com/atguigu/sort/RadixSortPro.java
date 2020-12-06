package com.atguigu.sort;

import java.util.Arrays;

/**
 * @program: dataStructure
 * @description: 支持负数的基数排序
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-12-06 19:29
 **/
public class RadixSortPro {
    public static void main(String[] args) {
        int[] arr = {-99, 53, -3, 542, 748, -48, 14, 214, -23, -56};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];

        //寻找最大值和最小值
        for (int i = 1; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
            minValue = Math.min(minValue, arr[i]);
        }

        //如果最小值为负数 则数组每个值减去最小值
        if (minValue < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] -= minValue;
            }
            //最大值也要减去  不然可能会发生位数变化
            maxValue -= minValue;
        }

        //取最大位数
        int maxLength = String.valueOf(maxValue).length();

        //表示10个桶
        int[][] bucket = new int[10][arr.length];

        // 记录每个桶实际存放几个数据，比如：bucketElementCount[0]记录着bucket[0]桶放入数据个数
        int[] bucketElementCount = new int[10];

        for (int i = 0, j = 1; i < maxLength; i++, j *= 10) {
            for (int k = 0; k < arr.length; k++) {
                int digitOfElement   = arr[k] / j % 10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[k];
                bucketElementCount[digitOfElement]++;
            }
            int index = 0;
            for (int l = 0; l < bucketElementCount.length; l++) {
                if (bucketElementCount[l] != 0) {
                    for (int k = 0; k < bucketElementCount[l]; k++) {
                        arr[index++] = bucket[l][k];
                    }
                }
                // 清空桶
                bucketElementCount[l] = 0;
            }
        }
        if (minValue < 0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] += minValue;
            }
        }
    }
}
