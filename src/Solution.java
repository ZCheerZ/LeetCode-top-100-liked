import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]==i+1) ;
            else {
                int now = i;
                while(nums[now]!=now+1){
                    int t = nums[nums[now]-1];
                    nums[nums[now]-1] = nums[now];
                    now  = t-1;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]!=i+1) res.add(i+1);
        }
        return res;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        int[] nums = {4,3,2,7,8,2,3,1};
        solution.findDisappearedNumbers(nums);
//        for (int i = 0; i < 5; i++) {
//            nums[i] = scanner.nextInt();
//        }
    }
}