package Q55_跳跃游戏;

import java.util.Scanner;

class Solution {
    public boolean canJump(int[] nums) {
        int pos = 0;
        for(int i= 0;i<nums.length;i++){
            if(i<=pos) pos = Math.max(pos,i+nums[i]);
            else return false;
            if(pos>=nums.length-1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}