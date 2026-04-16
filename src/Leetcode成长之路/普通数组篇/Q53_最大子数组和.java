package Leetcode成长之路.普通数组篇;

import java.util.Scanner;

class Q53_最大子数组和 {
    /*
    53. 最大子数组和
    给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    子数组是数组中的一个连续部分。
    输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
    输出：6
    解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
    */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int maxdp = nums[0];
        for(int i = 1; i<nums.length ;i++){
            maxdp = Math.max(nums[i],nums[i]+maxdp);
            res = Math.max(res,maxdp);
        }
        return res;
    }
    public static void main(String[] args) {
        Q53_最大子数组和 q53最大子数组和 = new Q53_最大子数组和();
        Scanner scanner = new Scanner(System.in);

    }
}