import java.util.*;
public class test {
    public static int  solve(int C, int L, int n, int[] prices, int[] distances){
        for(int i = 1;i<n;i++){
            if(distances[i]-distances[i-1]>C) {
                return -1;
            }
        }
        if(L<= C) return 0;
        int []dp = new int[L+1]; // 走当前到i需要耗费的前面充电桩最少的钱
        Arrays.fill(dp,-1);
        for(int i = 0;i<C;i++){
            dp[i] = 0;
        }
        for(int i = 0;i<n;i++){
            int start = distances[i];
            for(int j = start; j<start+C; j++){
                if(j > L) break;
                if(dp[j] == -1) dp[j] = prices[i];
                else {
                    if (dp[j] > prices[i]) dp[j] = prices[i];
                }
            }
        }
        int res = 0;
        for (int i = 1; i < L; i++) {
            if(dp[i] == -1) return -1;
            res += dp[i];
            System.out.println("i="+i+", dp[i]="+dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();

        int C = in.nextInt();
        int n = in.nextInt();
        int[] prices = new int[n];
        int[] distances = new int[n];
        for(int i = 0;i<n;i++){
            distances[i] = in.nextInt();
            prices[i] = in.nextInt();
        }
        System.out.println(solve(C,L,n,prices,distances));
    }




}
