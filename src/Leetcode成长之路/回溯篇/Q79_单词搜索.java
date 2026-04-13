package Leetcode成长之路.回溯篇;

import java.util.Scanner;

class Q79_单词搜索 {
    public boolean dfs(char[][] board, String word, int x, int y, int n) {
        if (n == word.length()) {
            return true;
        }
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == word.charAt(n)) {
            char t = board[x][y];
            board[x][y] = '0';
            boolean res =  dfs(board, word, x, y + 1, n + 1) ||
                    dfs(board, word, x + 1, y, n + 1) ||
                    dfs(board, word, x, y - 1, n + 1) ||
                    dfs(board, word, x - 1, y, n + 1);
            board[x][y] = t;
            return res;
        }
        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean res;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                res = dfs(board, word, i, j, 0);
                if(res) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q79_单词搜索 q79单词搜索 = new Q79_单词搜索();
        Scanner scanner = new Scanner(System.in);

    }
}