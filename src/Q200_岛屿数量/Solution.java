package Q200_岛屿数量;

import java.util.Scanner;

class Solution {
    int[][] go = {{1,0},{0,1},{-1,0},{0,-1}};
    void dfs(int x,int y,char[][] grid){
        for(int i = 0 ;i<4;i++){
            int xi = x + go[i][0];
            int yi = y + go[i][1];
            if(xi>=0&&xi<grid.length&&yi>=0&&yi<grid[xi].length&&grid[xi][yi]=='1'){
                grid[xi][yi] = '0';
                dfs(xi,yi,grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0 ; i< grid.length;i++){
            for(int j = 0 ; j< grid[i].length;j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(i,j,grid);
                }
            }
        }
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