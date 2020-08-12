package com.atguigu.sparsearray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: Jia_Q
 * @create: 2020-06-08 23:08
 **/
public class SparseArrayWrite {
    public static void main(String[] args) throws IOException {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[3][4] = 3;
        //输出原来的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //得到非零数据个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArr = new int[sum + 1][3];
        int count = 0;
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //保存
        BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\JavaWork\\dataStructure\\map.data", true));
        System.out.println();
        System.out.println("进行存档。。。");
        for (int i = 0; i < sparseArr.length; i++) {
            String s = "" + sparseArr[i][0] + "\t" + sparseArr[i][1] + "\t" + sparseArr[i][2] + "\t\n";
            bw.write(s);
        }
        bw.close();
    }
}
