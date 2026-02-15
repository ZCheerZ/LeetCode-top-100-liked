package Q3_无重复字符的最长子串;
import java.util.*;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        boolean hash[] = new boolean[128];
        for (int index = 0; index < s.length(); index++) {
            if(hash[s.charAt(index)]){
                res = Math.max(res,index-start);
                for (; s.charAt(index)!=s.charAt(start); start++) {
                    hash[s.charAt(start)] = false;
                }
                start++;
            }
            else hash[s.charAt(index)] = true;
        }
        res = Math.max(res,s.length()-start);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }
}