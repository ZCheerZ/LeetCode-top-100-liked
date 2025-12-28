package Q45_跳跃游戏2;

import java.util.Scanner;

class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int min_step = 0;
        int next_pos = nums[0];
        int cur_pos = nums[0];
        dp[0] = 0;
        for(int i = 1; i<nums.length ;i++){
            if(i<=cur_pos){
                dp[i] = min_step+1;
                if(next_pos < i+nums[i]){
                    next_pos = i+nums[i];
                }
                if(i == cur_pos){
                    cur_pos = next_pos;
                    min_step++;
                }
            }
        }
        return dp[nums.length-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}