package Q207_课程表;

import java.util.*;

class Solution {
    public void putq(LinkedList<Integer> q, int[] in){
        for(int i = 0 ; i<in.length ;i++){
            if(in[i]==0){
                q.addFirst(i);
                in[i]--;
            }
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer,List<Integer>> out = new HashMap<>();
        for(int i = 0; i<prerequisites.length ; i++){
            in[prerequisites[i][0]]++;
            if(out.containsKey(prerequisites[i][1])){
                out.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            else{
                List<Integer> t = new ArrayList<>();
                t.add(prerequisites[i][0]);
                out.put(prerequisites[i][1],t);
            }
        }
        LinkedList<Integer> q = new LinkedList<>();
        putq(q,in);
        while(!q.isEmpty()){
            int now = q.removeFirst();
            if(out.containsKey(now)){
                List<Integer> t = out.get(now);
                for(int i: t){
                    in[i]--;
                }
                out.remove(now);
            }
            putq(q,in);
        }
        for(int i = 0 ; i<in.length ;i++){
            if(in[i]>0){
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}