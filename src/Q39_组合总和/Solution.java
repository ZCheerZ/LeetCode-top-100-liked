package Q39_组合总和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
//    List<List<Integer>> res = new ArrayList<>();
//    public void backTrack(int[] candidates, int target , List<Integer> cur, int sum , int start){
//        if(sum>=target){
//            if(sum == target) res.add(new ArrayList<>(cur));
//            return ;
//        }
//        for(int i = start ;i<candidates.length;i++){
//            cur.add(candidates[i]);
//            sum+=candidates[i];
//            backTrack(candidates, target,cur, sum , i);
//            sum-=candidates[i];
//            cur.remove(cur.size()-1);
//        }
//
//    }
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<Integer> cur = new ArrayList<>();
//        int sum = 0;
//        backTrack(candidates, target,cur,sum,0);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] nums = new int[5];
//        for (int i = 0; i < 5; i++) {
//            nums[i] = scanner.nextInt();
//        }
//    }
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> cur = new ArrayList<>();
    public static void  trackback(int[] candidates,  int target ,int now ,int start){
        if(now >= target){
            if(now == target) res.add(new ArrayList<>(cur));
            return ;
        }
        for(int i = start ; i<candidates.length ; i++){
            cur.add(candidates[i]);
            now += candidates[i];
            trackback(candidates, target, now, i);
            now -= candidates[i];
            cur.remove(cur.size()-1);
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        trackback(candidates,target,0,0);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] candidates = new int[n];
        for(int i = 0 ; i<n ; i++){
            candidates[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<List<Integer>> res = combinationSum(candidates,target);
        for(List<Integer> t : res){
            for(int i : t){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}