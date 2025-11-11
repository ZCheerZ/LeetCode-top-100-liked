package Q1_两数之和;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        int target;
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
        target = scanner.nextInt();
        Solution solution = new Solution();
        int[] result = solution.twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}
