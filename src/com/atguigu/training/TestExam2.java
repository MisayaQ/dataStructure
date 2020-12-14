package com.atguigu.training;

/**
 * @program: dataStructure
 * @description:
 * @version: 1.0
 * @author: LiuJiaQi
 * @create: 2020-12-11 11:33
 **/
public class TestExam2 {
        public static void main(String[] args) {
            int[] num = new int[]{-2,1,-3,4,-1,2,1,-5,4};
            int maxSum = maxSum(num);
            System.out.println(maxSum);
        }
        private static int maxSum(int[] num) {
            int max = num[0];
            int maxSum = num[0];
            for (int i = 1; i < num.length; i++) {
                maxSum=Math.max(num[i], maxSum+num[i]);
                max=Math.max(max, maxSum);
            }
            return max;
        }

}
