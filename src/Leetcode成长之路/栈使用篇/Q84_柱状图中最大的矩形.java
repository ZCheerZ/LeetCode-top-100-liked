package Leetcode成长之路.栈使用篇;

import java.util.LinkedList;
import java.util.Scanner;

class Q84_柱状图中最大的矩形 {
//    84. 柱状图中最大的矩形
//    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//    求在该柱状图中，能够勾勒出来的矩形的最大面积。
//    输入：heights = [2,1,5,6,2,3]
//    输出：10
//    解释：最大的矩形为[5,6]，面积为 10
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.getFirst()]){
                int index = stack.removeFirst();
                if(stack.isEmpty()) res = Math.max(res, i * heights[index]);
                else res = Math.max(res, (i - stack.getFirst() -1) * heights[index]);
            }
            stack.addFirst(i);
        }
        int len = heights.length;
        while(!stack.isEmpty()){
            int index = stack.removeFirst();
            if(stack.isEmpty()) res = Math.max(res, len * heights[index]);
            else res = Math.max(res, (len - stack.getFirst() -1) * heights[index]);
        }
        return res;
    }
    public static void main(String[] args) {
        Q84_柱状图中最大的矩形 q84柱状图中最大的矩形 = new Q84_柱状图中最大的矩形();
        Scanner scanner = new Scanner(System.in);

    }
}