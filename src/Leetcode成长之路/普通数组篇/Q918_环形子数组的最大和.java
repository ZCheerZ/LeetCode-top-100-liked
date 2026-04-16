package Leetcode成长之路.普通数组篇;

import java.util.Scanner;

class Q918_环形子数组的最大和 {
    /*
    918. 环形子数组的最大和  (最大子数组之和的变种)
    给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
    输入：nums = [5,-3,5]
    输出：10
    解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
    */
    public int maxSubarraySumCircular(int[] nums) {
        int max_ = nums[0];
        int min_ = nums[0];
        int res_max = nums[0];
        int res_min = nums[0];
        int sum = nums[0];
        if(nums.length == 1) return nums[0];
        for(int i = 1; i< nums.length; i++ ){
            sum += nums[i];
            max_ = Math.max(max_+nums[i],nums[i]);
            res_max = Math.max(res_max,max_);
            min_ = Math.min(min_+nums[i],nums[i]);
            res_min = Math.min(res_min,min_);
        }
        if(res_max < 0) return res_max;
        return Math.max(res_max,sum-res_min);
    }
    public static void main(String[] args) {
        Q918_环形子数组的最大和 q918环形子数组的最大和 = new Q918_环形子数组的最大和();
        Scanner scanner = new Scanner(System.in);

    }
}