package com.atguigu.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-11-30 10:49
 **/
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,-4,-1,0,1};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len< 3) {
            System.out.println("数组长度小于3");
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            //跳出循环后 如果i的下一位和i相等 则结果也是一样的 直接continue跳出 继续循环
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }
}
