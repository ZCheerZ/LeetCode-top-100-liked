package Leetcode成长之路.回溯篇;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public  void dfs(int[] candidates, int target, int sumNow , int index){
        if(sumNow >= target){
            if(sumNow == target){
                res.add(new ArrayList<>(cur));
            }
            return  ;
        }
        for(int i = index ; i<candidates.length ; i++){
            cur.add(candidates[i]);
            dfs(candidates, target, sumNow + candidates[i], i);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates,target,0,0);
        return res;
    }
    public static void main(String[] args) {
        Q39_组合总和 q39组合总和 = new Q39_组合总和();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int candidates[] = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        List<List<Integer>> res = q39组合总和.combinationSum(candidates,target);
        for(List<Integer> cur : res){
            for(int i : cur)
                System.out.print(i + " ");
            System.out.println();
        }

    }
}