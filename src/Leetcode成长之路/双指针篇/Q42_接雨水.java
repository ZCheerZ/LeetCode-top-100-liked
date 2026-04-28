package Leetcode成长之路.双指针篇;

import java.util.Scanner;

class Q42_接雨水 {
//    42. 接雨水
//    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//    输出：6
//    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
    public int trap(int[] height) {
        int res = 0;
        int l [] = new int[height.length];
        int r [] = new int[height.length];
        l[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            l[i]  =  Math.max(l[i-1],height[i]);
        }
        r[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0 ; i--) {
            r[i]  =  Math.max(r[i+1],height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            res += Math.min(l[i],r[i]) - height[i];
        }
        return res;

    }
    public static void main(String[] args) {
        Q42_接雨水 q42接雨水 = new Q42_接雨水();
        Scanner scanner = new Scanner(System.in);

    }
}