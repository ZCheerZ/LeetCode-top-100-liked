package Q283_移动零;

import java.util.Scanner;

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0 ; j<nums.length;j++){
            if(nums[j]!=0){
                nums[i++] = nums[j];
            }
        }
        for(;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}