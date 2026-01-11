package Q994_腐烂的橘子;

import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    int res = 0;
    int [][]min_Rott;
    int [][]go = {{0,1},{1,0},{0,-1},{-1,0}};
    public void bfs(int[][] grid){
        int M = grid.length;
        int N = grid[0].length;
        min_Rott = new int[M][N];
        LinkedList<int[]> queue = new  LinkedList<>();
        int count = 0; // count 表示新鲜橘子的数量
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] t = queue.getFirst();
            queue.removeFirst();
            int min_ = min_Rott[t[0]][t[1]];
            for(int i = 0 ;i<4;i++){
                int xi = t[0]+go[i][0];
                int yi = t[1]+go[i][1];
                if(xi>=0&&xi<M&&yi>=0&&yi<N&&grid[xi][yi]==1){
                    queue.add(new int[]{xi,yi});
                    grid[xi][yi] = 2;
                    min_Rott[xi][yi] = min_+1;
                    res = min_+1;
                    count--;
                }
            }
        }
        if(count!=0) res = -1;
    }
    public int orangesRotting(int[][] grid) {
        bfs(grid);
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = scanner.nextInt();
        }
    }
}