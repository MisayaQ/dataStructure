package com.atguigu.training;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-12-08 22:10
 **/
public class SortList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        int[] a = {1, 2, 5, 67, 2, 1, 23, 5};
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        removeDuplicate(list);
        System.out.println(list);

    }

    public static List removeDuplicate(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
        return list;
    }

    public static List removeDuplicate2(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }
}

