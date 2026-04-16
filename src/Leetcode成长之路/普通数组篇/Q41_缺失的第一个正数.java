package Leetcode成长之路.普通数组篇;

import java.util.Scanner;

class Q41_缺失的第一个正数 {
    /*
    41. 缺失的第一个正数
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
    输入：nums = [1,2,0]
    输出：3
    解释：范围 [1,2] 中的数字都在数组中。
    */
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i<nums.length ;i++){
            int num = nums[i];
            while(num-1 < nums.length && num-1>=0 && nums[num-1] != num){
                int t = nums[num-1];
                nums[num-1] = num;
                num = t;
            }
        }
        for(int i = 0; i<nums.length ;i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }
    public static void main(String[] args) {
        Q41_缺失的第一个正数 q41缺失的第一个正数 = new Q41_缺失的第一个正数();
        Scanner scanner = new Scanner(System.in);

    }
}