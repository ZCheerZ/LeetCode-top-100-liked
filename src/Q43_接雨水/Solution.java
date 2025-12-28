package Q43_接雨水;

import java.util.Scanner;

class Solution {
    public int trap(int[] height) {
        int[] l = new int[height.length];
        int[] r = new int[height.length];
        l[0] = height[0];
        r[height.length-1] = height[height.length-1];
        for(int i = 1;  i<height.length ;i++){
            l[i] = Math.max(l[i-1],height[i]);
        }
        for(int i = height.length-2;  i>=0;i--){
            r[i] = Math.max(r[i+1],height[i]);
        }
        int res = 0;
        for(int i = 0; i<height.length ;i++){
            res += Math.min(r[i],l[i])-height[i];
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