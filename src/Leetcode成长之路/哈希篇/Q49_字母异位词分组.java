package Leetcode成长之路.哈希篇;

import java.util.*;

class Q49_字母异位词分组 {
//    49. 字母异位词分组
//    给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//    输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//    输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//    解释：
//    在 strs 中没有字符串可以通过重新排列来形成 "bat"。
//    字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
//    字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String t : strs){
            char tmp[] = t.toCharArray();
            Arrays.sort(tmp);
            String sortStr = String.valueOf(tmp);
            if(map.containsKey(sortStr)) map.get(sortStr).add(t);
            else {
                List<String> list = new ArrayList<>();
                list.add(t);
                map.put(sortStr,list);
            }
        }
        for(List<String> t : map.values()){
            res.add(t);
        }
        return res;

    }
    public static void main(String[] args) {
        Q49_字母异位词分组 q49字母异位词分组 = new Q49_字母异位词分组();
        Scanner scanner = new Scanner(System.in);

    }
}