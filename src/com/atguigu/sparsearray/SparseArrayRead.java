package com.atguigu.sparsearray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: Jia_Q
 * @create: 2020-06-08 23:32
 **/
public class SparseArrayRead {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("F:\\JavaWork\\dataStructure\\map.data"));
        List<String> list = new ArrayList<>();
        String s = "";
        //读取文件中每一行的数据 存储到string中
        while ((s = br.readLine()) != null) {
            System.out.println(s);
            list.add(s);
        }
//        System.out.println(list.size());//4

        //创建数组，用来存储读取到的稀疏数组
        int[][] newSparseArrayRead = new int[list.size()][3];
        //获取第一行的数据
        String s1 = list.get(0);
        //用\t进行分割 得到第一行三个数据 存入到一个String数组
        String[] split = s1.split("\t");

        //先将11 11 3放入稀疏数组第一行中
        newSparseArrayRead[0][0] = Integer.parseInt(split[0]);
        newSparseArrayRead[0][1] = Integer.parseInt(split[1]);
        newSparseArrayRead[0][2] = Integer.parseInt(split[2]);

        //设置count值，进行后面的判断。二维数组的行数。
        int count = 0;
        //遍历的时候 设置i=1 即从第二行开始读取 1 2 1
        for (int i = 1; i < list.size(); i++) {
            String str = list.get(i);
            String[] strings = str.split("\t");
            count++;
            for (int j = 0; j < strings.length; j++) {
                newSparseArrayRead[count][j] = Integer.parseInt(strings[j]);
            }
        }
        System.out.println("读取文件后建立的稀疏数组：");
        for (int i = 0; i < newSparseArrayRead.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", newSparseArrayRead[i][0], newSparseArrayRead[i][1], newSparseArrayRead[i][2]);
        }

        //从二维数组转换为原始数组
        //1.先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] chessArr2 = new int[newSparseArrayRead[0][0]][newSparseArrayRead[0][1]];
        //2.在读取稀疏数组后几行的数据（从第二行开始），并赋给原始的二维数组 即可
        for (int i = 1; i < newSparseArrayRead.length; i++) {
            chessArr2[newSparseArrayRead[i][0]][newSparseArrayRead[i][1]] = newSparseArrayRead[i][2];
        }

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复好的二维数组：");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
