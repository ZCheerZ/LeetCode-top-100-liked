package Q131_分割回文串;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<String>> res;
    List<String> t;
    public boolean isRe(String cur){
        for(int i=0 ;i<cur.length()/2;i++){
            if(cur.charAt(i) != cur.charAt(cur.length()-1-i)) return false;
        }
        return true;
    }
    public void traceBack(int n, String s) {
        if(n == s.length()){
            res.add(new ArrayList<>(t));
            return ;
        }
        for(int i = n ; i<s.length();i++ ){
            String cur = s.substring(n,i+1);
            if(isRe(cur)){
                t.add(cur);
                traceBack(i+1,s);
                t.remove(t.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        for(int i = 0 ; i<s.length();i++ ){
            t = new  ArrayList<>();
            String cur = s.substring(0,i+1);
            if(isRe(cur)){
                t.add(cur);
                traceBack(i+1,s);
            }
        }
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