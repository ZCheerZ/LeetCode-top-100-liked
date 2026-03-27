package AAA手撕题;

import java.util.*;

public class A面经字节_小于n的最大数 {
/*题目
给定一个数n，如23121，给定一组数字a,如｛2，4，9｝，求a中元素组成的小于n的最大数，如小于23121的最大数为22999
23121 3
2 4 9
*/
    static int res = 0;
    public static int search(int[] a, int x) {
        // 找到小于等于x 的最大数
        int l = 0, r = a.length - 1;
        int mid;
        while (l < r) {
            mid = l + r + 1 >> 1;
            if(a[mid] <= x) l = mid;
            else r = mid -1;
        }
        return l;
    }
    public static void dfs(String n , int[] a , int index ,boolean flag , String cur){
        if(index == n.length()){
            if(Integer.parseInt(cur) < Integer.parseInt(n))
                res = Math.max(res,Integer.parseInt(cur));
            return;
        }
        if(index == 0) dfs(n,a,index+1, true,cur+"0");
        if(flag){
            dfs(n,a,index+1, true,cur+ a[a.length - 1]);
        }
        else {
            int l = search(a,n.charAt(index)-'0');
            if(a[l] > n.charAt(index)-'0'){
                return ;
            }
            else if(a[l] < n.charAt(index)-'0'){
                dfs(n,a,index+1, true,cur+ a[l]);
            }
            else{
                dfs(n,a,index+1, false,cur+ a[l]);
                if(l != 0)
                    dfs(n,a,index+1, true,cur+ a[l - 1]);
            }
        }
    }
    
    public static int solve(int n, int[] a) {
        Arrays.sort(a);
        String target = Integer.toString(n);
        dfs(target,a,0,false,"");
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(solve(n, a));
    }

}
