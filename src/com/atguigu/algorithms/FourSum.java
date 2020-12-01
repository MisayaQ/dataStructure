package com.atguigu.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-11-30 15:58
 **/
public class FourSum {
    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = new int[]{1, 0, -1, 0, -2, 2, -2,2};
        List<List<Integer>> lists = fourSum.fourSum(nums, 0);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 4 || nums == null) {
            return ans;
        }
        //排序
        Arrays.sort(nums);
        //第一层循环
        for (int k = 0; k < len - 3; k++) {
            //去重
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            int max1 = nums[k] + nums[len - 1] + nums[len - 2] + nums[len - 3];
            if (min1 > target) {
                break;
            }
            if (max1 < target) {
                continue;
            }
            //第二层循环
            for (int i = k + 1; i < len - 2; i++) {
                //去重
                if (i > k+1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                //定义指针j 指向i+1
                int j = i + 1;
                //定义尾指针h
                int h = len - 1;
                int min = nums[k] + nums[i] + nums[j] + nums[j + 1];
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (min > target) {
                    break;
                }
                if (max < target) {
                    continue;
                }
                while (j < h) {
                    int sum = nums[k] + nums[i] + nums[j] + nums[h];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        while (j < h && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < h && nums[h] == nums[h - 1]) {
                            h--;
                        }
                        j++;
                        h--;
                    } else if (sum < target) {
                        j++;
                    } else if (sum > target) {
                        h--;
                    }
                }

            }
        }
        return ans;
    }
}
