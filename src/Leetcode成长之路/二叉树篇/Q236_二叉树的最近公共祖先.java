package Leetcode成长之路.二叉树篇;

import java.util.Scanner;

class Q236_二叉树的最近公共祖先 {
    /*
    236. 二叉树的最近公共祖先
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出：3
    解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
    */
    public TreeNode dfs(TreeNode cur, TreeNode p, TreeNode q) {
        if(cur == null || cur == p|| cur == q) return cur;
        TreeNode left = dfs(cur.left,p,q);
        TreeNode right = dfs(cur.right,p,q);
        if(left != null && right != null) return cur;
        if(left == null) return right;
        return left;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root,p,q);
    }
    public static void main(String[] args) {
        Q236_二叉树的最近公共祖先 q236二叉树的最近公共祖先 = new Q236_二叉树的最近公共祖先();
        Scanner scanner = new Scanner(System.in);

    }
}