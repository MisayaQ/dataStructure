package com.atguigu.training;

/**
 * @program: 顺时针陀螺旋转
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-12-11 11:11
 **/
public class TestExam {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printReverse(arr);
    }
    public static void printReverse(int arr[][]){
        int right = arr[0].length;
        int indexRight = 0;
        int down = arr.length - 1;
        int indexDown = 0;
        int flag = 1;
        while (true) {
            int i = 0;
            int j =0;
            if (right != 0) {
                for (i = 0; i < right; i++) {
                    System.out.print(arr[indexDown][indexRight + i * flag] + " ");
                }
                indexRight += flag * (right - 1);
                indexDown += flag;
                right--;
            }
            if (down == 0) {
                break;

            }
            if (down != 0) {
                for (j = 0; j < down; j++) {
                    System.out.print(arr[j*flag+indexDown][indexRight] + " ");
                }
                indexDown += flag * (down - 1);
                indexRight += flag * (-1);
                down--;
            }
            if (right == 0) {
                break;
            }
            flag = -flag;
        }
    }

}
