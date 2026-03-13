import java.util.*;
public class test {
    static int ans = 0;
    public static void  dfs(int[] qian, int l , int r){
        if(l>=r) return ;
        for(int i = l ; i<r ; i++){
            if(qian[i]-qian[l-1] == qian[r]-qian[i]){
                ans++;
                dfs(qian,l,i);
                dfs(qian,i+1,r);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        int[] qian = new int[n+1];
        for(int i = 0 ; i< n ; i++){
            qian[i+1] = qian[i]+in.nextInt();
        }
        dfs(qian,1,n);
        System.out.println(ans);
    }
}
