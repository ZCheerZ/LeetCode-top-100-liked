package Leetcode成长之路.图论篇;

import java.util.*;

class Q207_课程表 {
    /*
    207. 课程表  拓扑排序解决  找出度和入度，从入度为0的节点开始，然后减所有当前入度节点的出度节点
    输入：numCourses = 2, prerequisites = [[1,0]]
    输出：true
    解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
    输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
    输出：false
    解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> out = new HashMap<>();
        for (int t[] : prerequisites) {
            in[t[0]]++;
            if (out.containsKey(t[1])) {
                out.get(t[1]).add(t[0]);
            } else {
                out.put(t[1], new ArrayList<>());
                out.get(t[1]).add(t[0]);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) queue.addFirst(i);
        }
        while (!queue.isEmpty()) {
            int index = queue.removeLast();
            numCourses--;
            if (!out.containsKey(index)) continue;
            for (int i : out.get(index)) {
                in[i]--;
                if (in[i] == 0) queue.addFirst(i);
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        Q207_课程表 q207课程表 = new Q207_课程表();
        Scanner scanner = new Scanner(System.in);

    }
}