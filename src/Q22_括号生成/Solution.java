package Q22_括号生成;

import java.util.*;

class Solution {
    List<String> res = new ArrayList<>();
    int n;
    public void traceBack(String cur,int left,int right){
        if(left == n && right == n){
            res.add(cur);
            return;
        }
        if(left<n){
            cur += '(';
            traceBack(cur,left+1,right);
            cur = cur.substring(0, cur.length() - 1);
        }
        if(left>right && right < n){
            cur+= ')';
            traceBack(cur,left,right+1);
            cur = cur.substring(0, cur.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        traceBack("",0,0);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Solution().generateParenthesis(n));
    }
}
