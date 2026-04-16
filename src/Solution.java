import java.util.Scanner;

class Solution {
    public void solve(int[] nums) {
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in = s.nextLine();
        StringBuffer res = new StringBuffer();
        for(char t : in.toCharArray()){
            char low = Character.toLowerCase(t);
            if( low  == 'a' || low == 'e' || low == 'i' || low == 'o' || low == 'u'){
                res.append(Character.toUpperCase(t));
            }
            else res.append(t);
        }
        System.out.println(res);
    }
}