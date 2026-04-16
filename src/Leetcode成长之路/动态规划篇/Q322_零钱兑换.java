package Leetcode成长之路.动态规划篇;

import java.util.Scanner;

class Q322_零钱兑换 {
    /*
    322. 零钱兑换
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    你可以认为每种硬币的数量是无限的。
    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1
    */
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        dp[0] = 1;// 后续减一
        for(int coin : coins){
            for(int i = 1; i<=amount ; i++){
                if(i >= coin && dp[i-coin] > 0){
                    if(dp[i] == 0) dp[i] = dp[i-coin]+1;
                    else  dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount]-1;
    }
    public static void main(String[] args) {
        Q322_零钱兑换 q322零钱兑换 = new Q322_零钱兑换();
        Scanner scanner = new Scanner(System.in);

    }
}