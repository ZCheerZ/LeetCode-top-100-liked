package Leetcode成长之路.滑动窗口篇;

import java.util.*;

class Q438_找到字符串中所有字母异位词 {
    /*
    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
    输入: s = "cbaebabacd", p = "abc"
    输出: [0,6]
    解释:
    起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
    起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    一定不能用boolean 两个原因
    主要原因是p里面有重复的元素！
    次要原因是 s = abac p = abc 把a取false c取true 那么check还是跟cur不相等！ 因为s滑动窗口下字符可能会重复！
    */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(p.length() > s.length()) return res;
        int check[] = new int[128];
        int cur[] = new int[128];
        for(int i = 0 ; i<p.length(); i++){
            check[p.charAt(i)]++;
            cur[s.charAt(i)]++;
        }
        if(Arrays.equals(check,cur)) res.add(0);
        for(int end = p.length(); end < s.length() ;end++){
            int start = end - p.length();
            cur[s.charAt(start)]--;
            cur[s.charAt(end)]++;
            if(Arrays.equals(check,cur)) res.add(start+1);
        }
        return res;
    }
    public static void main(String[] args) {
        Q438_找到字符串中所有字母异位词 q438找到字符串中所有字母异位词 = new Q438_找到字符串中所有字母异位词();
        Scanner scanner = new Scanner(System.in);

    }
}