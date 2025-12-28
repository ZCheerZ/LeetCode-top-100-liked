package Q11_盛最多水的容器;

import java.util.Scanner;

class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i= 0 , j = height.length-1;
        while(i<=j){
            int minh = Math.min(height[i], height[j]);
            int water = minh * (j-i);
            res = Math.max(res, water);
            if(minh == height[i]) i++;
            else j--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}