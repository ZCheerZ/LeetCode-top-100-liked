package Leetcode成长之路.子串篇;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Q560_和为K的子数组 {
    /*
    560. 和为 K 的子数组
    给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
    子数组是数组中元素的连续非空序列。
    思路： 巧妙利用前缀和 求出子串子数组的和  类似的题目如  AABBA 请你找出多少个子串里面有 n个A字符
    输入：nums = [1,1,1], k = 2
    输出：2
    输入：nums = [1,2,3], k = 3
    输出：2
    */
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i : nums){
            sum += i;
            if(map.containsKey(sum-k))  res += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return res;
    }
    public static void main(String[] args) {
        Q560_和为K的子数组 q560和为K的子数组 = new Q560_和为K的子数组();
        Scanner scanner = new Scanner(System.in);

    }
}