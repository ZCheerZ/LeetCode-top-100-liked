package Leetcode成长之路.滑动窗口篇;

import java.util.Scanner;

class Q3_无重复字符的最长子串 {
    /*
    3. 无重复字符的最长子串
    给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    */
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        boolean[] hash = new boolean[128];
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            // 想想没有这个相等咋办？
            if (hash[s.charAt(end)]) {
                // 每次一开始的时候就要判断！
                len = Math.max(len, end - start);
                while (s.charAt(end) != s.charAt(start)) hash[s.charAt(start++)] = false;
                start++;
            } else hash[s.charAt(end)] = true;
        }
        // 所以一定要记得！
        len = Math.max(len, s.length() - start);
        return len;
    }

    public static void main(String[] args) {
        Q3_无重复字符的最长子串 q3无重复字符的最长子串 = new Q3_无重复字符的最长子串();
        Scanner scanner = new Scanner(System.in);

    }
}