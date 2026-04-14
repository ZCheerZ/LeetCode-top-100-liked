import java.util.Scanner;

class Solution {
    public void solve(int[] nums) {
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        String sp[] =  in.split(" ");
        int sum = 0;
        for(String t : sp){
            System.out.println(t);
            sum  += t.length();
        }
        System.out.printf("%f", (double)sum / sp.length);
    }
}