package Q128_最长连续序列;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int num : set) { // 从set里面取值 避免重复的值
            if(!set.contains(num-1)){
                int count = 1;
                int currentNum =num;
                while(set.contains(currentNum+1)){
                    currentNum++;
                    count++;
                }
                res = Math.max(res,count);
            }
        }
//        for (int i = 0; i < nums.length; i++) {
//            if(set.contains(nums[i]-1)){
//                continue;
//            }else {
//                int count = 0;
//                int currentNum = nums[i];
//                while(set.contains(currentNum)){
//                    currentNum++;
//                    count++;
//                }
//                res = Math.max(res,count);
//            }
//        }


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