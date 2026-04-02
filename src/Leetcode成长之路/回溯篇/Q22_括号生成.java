package Leetcode成长之路.回溯篇;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Q22_括号生成 {
    List<String> res = new ArrayList<>();

    public void dfs(int left, int right,int n , String cur) {
        if(left == n && right == n){
            res.add(cur);
            return ;
        }
        if(left < n) dfs(left+1, right, n, cur+"(");
        if(right < left) dfs(left, right+1, n, cur+")");
    }


    public List<String> generateParenthesis(int n) {
        dfs(0,0,n, "");
        return res ;
    }
    public static void main(String[] args) {
        Q22_括号生成 q22括号生成 = new Q22_括号生成();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> res = q22括号生成.generateParenthesis(n);
        for(String s : res){
            System.out.println(s);
        }
    }
}