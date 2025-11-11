package Q39_组合总和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void backTrack(int[] candidates, int target , List<Integer> cur, int sum , int start){
        if(sum>=target){
            if(sum == target) res.add(new ArrayList<>(cur));
            return ;
        }
        for(int i = start ;i<candidates.length;i++){
            cur.add(candidates[i]);
            sum+=candidates[i];
            backTrack(candidates, target,cur, sum , i);
            sum-=candidates[i];
            cur.remove(cur.size()-1);
        }

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        int sum = 0;
        backTrack(candidates, target,cur,sum,0);
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