package Leetcode成长之路.哈希篇;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Q1_两数之和 {
    /*
    1. 两数之和
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    输入：nums = [2,7,11,15], target = 9
    输出：[0,1]
    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    };
    public static void main(String[] args) {
        Q1_两数之和 q1两数之和 = new Q1_两数之和();
        Scanner scanner = new Scanner(System.in);

    }
}