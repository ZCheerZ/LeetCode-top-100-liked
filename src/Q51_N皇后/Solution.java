package Q51_N皇后;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<String>> res = new ArrayList<>();
    int[] pos;
    boolean[] diag1;
    boolean[] diag2;
    String getRow(int q,int n){
        String str = "";
        for(int i = 1;i<=n;i++){
            if(i==q) str+="Q";
            else str+=".";
        }
        return str;
    }

    void traceBack(int n,List<String> cur){
        int num = cur.size();
        if(num==n){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 1;i<=n;i++){
            if(pos[i]!=1&&!diag1[num+1+i]&&!diag2[n-i+num+1]){
                cur.add(getRow(i,n));
                pos[i] = 1;
                diag1[num+1+i] = true;
                diag2[n-i+num+1] = true;
                traceBack(n,cur);
                pos[i] = 0;
                diag1[num+1+i] = false;
                diag2[n-i+num+1] = false;
                cur.remove(num);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        for(int i =1 ;i <=n ;i++){
            pos = new int[n+1];
            diag1 = new boolean[(n+1) * 2];
            diag2 = new boolean[(n+1) * 2];
            List<String> cur = new ArrayList<>();
            cur.add(getRow(i,n));
            pos[i] = 1;
            diag1[i+1] = true;
            diag2[n-i+1] = true;
            traceBack(n,cur);
        }
        return res;
    }
}