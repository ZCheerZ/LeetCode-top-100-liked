package Q49_字母异位词分组;

import java.util.*;

class Solution {
    // strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    // [["bat"],["nat","tan"],["ate","eat","tea"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> s = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!s.containsKey(key)){
                s.put(key,new ArrayList<String>());

            }
            s.get(key).add(str);
        }
        s.forEach((k,v)->res.add(v));
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}