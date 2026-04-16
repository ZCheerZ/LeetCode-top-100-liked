package Leetcode成长之路.技巧篇;

import java.util.Scanner;

class Q136_只出现一次的数字 {
    /*
    136. 只出现一次的数字
    给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    输入：nums = [4,1,2,1,2]
    输出：4
    思路：异或思路
    */
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums){
            res = res ^ i;
        }
        return res;
    }
    public static void main(String[] args) {
        Q136_只出现一次的数字 q136只出现一次的数字 = new Q136_只出现一次的数字();
        Scanner scanner = new Scanner(System.in);

    }
}