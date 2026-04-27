package Leetcode成长之路.二叉树篇;

import java.util.Scanner;

class Q124_二叉树中的最大路径和 {
    /*
    124. 二叉树中的最大路径和
    二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
    路径和 是路径中各节点值的总和。
    给你一个二叉树的根节点 root ，返回其 最大路径和 。
    输入：root = [1,2,3]
    输出：6
    解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
    */
    int res = Integer.MIN_VALUE;
    public int dfs(TreeNode cur) {
        if(cur == null) return 0;
        int left = Math.max(0,dfs(cur.left)) ;
        int right = Math.max(0,dfs(cur.right)) ;
        res = Math.max(left+right+cur.val , res);
        return Math.max(left,right)+cur.val;

    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }
    public static void main(String[] args) {
        Q124_二叉树中的最大路径和 q124二叉树中的最大路径和 = new Q124_二叉树中的最大路径和();
        Scanner scanner = new Scanner(System.in);

    }
}