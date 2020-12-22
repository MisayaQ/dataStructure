package com.atguigu.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-12-22 17:51
 **/
public class ListUnion {
    public static void main(String[] args) {
        System.out.println(union(Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 4)));
    }

    static List<Integer> union(List<Integer> a, List<Integer> b) {
        // 在这儿实现
        List<Integer> listAll = new ArrayList<>();
        if (a == null || a.size() == 0) {
            listAll = a;
        } else if (b == null || b.size() == 0) {
            listAll = b;
        } else {
            for (int i = 0; i < a.size(); i++) {// 遍历list1
                boolean flag = false;
                for (int j = 0; j < b.size(); j++) {
                    if (a.get(i).equals(b.get(j))) {
                        flag = true;// 找到相同项，跳出本层循环
                        break;
                    }
                }
                if (!flag) {// 不相同，加入list3中
                    listAll.add(a.get(i));
                }
            }
        }
        for (int k = 0; k < b.size(); k++) {
            listAll.add(b.get(k));
        }
        return listAll;

//        // 在这儿实现
//        List<Integer> listAll = new ArrayList<Integer>();
//        for (Integer a1 : a) {
//            listAll.add(a1);
//        }
//        for (Integer b1 : b) {
//            listAll.add(b1);
//        }
//        listAll = new ArrayList<Integer>(new HashSet<>(listAll));
//        return listAll;
    }
}


