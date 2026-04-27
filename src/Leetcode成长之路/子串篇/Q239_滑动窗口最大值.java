package Leetcode成长之路.子串篇;

import java.util.*;

class Q239_滑动窗口最大值 {
//    239. 滑动窗口最大值
//    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//    返回 滑动窗口中的最大值 。
//    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//    输出：[3,3,5,5,6,7]
//    解释：滑动窗口的位置                   最大值
//    [1  3  -1] -3  5  3  6  7       3
//     1 [3  -1  -3] 5  3  6  7       3
//     1  3 [-1  -3  5] 3  6  7       5
//     1  3  -1 [-3  5  3] 6  7       5
//     1  3  -1  -3 [5  3  6] 7       6
//     1  3  -1  -3  5 [3  6  7]      7
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int index = 0;
        int n = k;
        while(k-- != 0){
            while (!queue.isEmpty() && nums[queue.getFirst()] <= nums[index]) queue.removeFirst();
            queue.addFirst(index++);
        }
        int res[] = new int[nums.length - n +1];
        res[0] = nums[queue.getLast()];
        for (int end = index; end < nums.length; end++) {
            int start = end - n;
            if(queue.getLast() <= start)  queue.removeLast();
            while (!queue.isEmpty() && nums[queue.getFirst()] <= nums[end]) queue.removeFirst();
            queue.addFirst(end);
            res[start+1] = nums[queue.getLast()];
        }
        return res;
    }
    
    public static void main(String[] args) {
        Q239_滑动窗口最大值 q239_滑动窗口最大值 = new Q239_滑动窗口最大值();
        Scanner scanner = new Scanner(System.in);

    }
}