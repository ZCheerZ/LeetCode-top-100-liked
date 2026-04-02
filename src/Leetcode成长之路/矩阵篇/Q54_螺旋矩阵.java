package Leetcode成长之路.矩阵篇;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q54_螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int [][]go  = {{0,1},{1,0},{0,-1},{-1,0}};
        int x = 0, y = 0;
        int index = 0;
        while (true){
            if(res.size() < row * col){
                res.add(matrix[x][y]);
                matrix[x][y] = 101;
                int xt = x+go[index][0];
                int yt = y+go[index][1];
                if(xt >= row || xt < 0 || yt >= col || yt < 0 || matrix[xt][yt] == 101){
                    index  = (index + 1) % 4 ;
                }
                x = x+go[index][0];
                y = y+go[index][1];
            }
            else break;
        }
        return res;
    }
    public static void main(String[] args) {
        Q54_螺旋矩阵 Q54_螺旋矩阵 = new Q54_螺旋矩阵();
        Scanner scanner = new Scanner(System.in);
    }

}
