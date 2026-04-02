package Leetcode成长之路.动态规划篇;

import java.util.Scanner;

class Q5_最长回文子串 {
    /*给你一个字符串 s，找到 s 中最长的 回文 子串。
    示例 1：
    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。*/
    public String longestPalindrome(String s) {
        String res = "";
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        for(int len = 1 ; len <= n ; len++){
            for(int left = 0 ; left<n ;left++){
                int right = len + left -1;
                if(right >= n) break;
                if(s.charAt(left) == s.charAt(right)){
                    if(len <= 3){
                        dp[left][right] = true;
                    }
                    else dp[left][right] = dp[left+1][right-1];
                    if(dp[left][right] && res.length()<len){
                        res = s.substring(left,right+1);
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Q5_最长回文子串 q5最长回文子串 = new Q5_最长回文子串();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(q5最长回文子串.longestPalindrome(s));
    }
}