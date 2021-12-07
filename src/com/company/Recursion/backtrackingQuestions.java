package com.company.Recursion;

public class backtrackingQuestions {
    public static void main(String[] args) {
        int[][] board = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        if (sudokuSolver(board)) print2d(board);
        else System.out.println(-1);
    }

    private static void print2d(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    static boolean sudokuSolver(int[][] board) {
        int n = board.length;
        int r = -1;
        int c = -1;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    r = i;
                    c = j;
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }
        if (flag) return true;
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, r, c, i)) {
                board[r][c] = i;
                if (sudokuSolver(board)) return true;
                else board[r][c] = 0;
            }
        }
        return false;
    }

    static boolean isSafe(int[][] board, int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == n || board[r][i] == n) return false;
        }
        int s = 3;
        int x = r - r % s;
        int y = c - c % s;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == n) return false;
            }
        }
        return true;
    }

    static int nKnights(boolean[][] board, int r, int c, int t) {
        if (t == 0) {
            display(board);
            System.out.println();
            return 1;
        }
        if (r == board.length - 1 && c == board.length) return 0;
        int count = 0;
        if (c == board.length) {
            count += nKnights(board, r + 1, 0, t);
            return count;
        }
        if (isKnightSafe(board, r, c)) {
            board[r][c] = true;
            count += nKnights(board, r, c + 1, t - 1);
            board[r][c] = false;
        }
        count += nKnights(board, r, c + 1, t);
        return count;
    }

    private static boolean isKnightSafe(boolean[][] board, int r, int c) {
        if (r - 2 >= 0 && c - 1 >= 0 && board[r - 2][c - 1]) return false;
        if (r - 2 >= 0 && c + 1 < board.length && board[r - 2][c + 1]) return false;
        if (r - 1 >= 0 && c - 2 >= 0 && board[r - 1][c - 2]) return false;
        return r - 1 < 0 || c + 2 >= board.length || !board[r - 1][c + 2];
    }

    static int nQueens(boolean[][] board, int r) {
        if (r == board.length) {
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int c = 0; c < board.length; c++) {
            if (isQueenSafe(board, r, c)) {
                board[r][c] = true;
                count += nQueens(board, r + 1);
                board[r][c] = false;
            }
        }
        return count;
    }

    private static boolean isQueenSafe(boolean[][] board, int r, int c) {
        for (int i = 0; i < r; i++) {
            if (board[i][c]) return false;
        }
        int l = Math.min(r, c);
        for (int i = 0; i <= l; i++) {
            if (board[r - i][c - i]) return false;
        }
        int rt = Math.min(r, board.length - 1 - c);
        for (int i = 0; i <= rt; i++) {
            if (board[r - i][c + i]) return false;
        }
        return true;
    }

    private static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean i : row) {
                if (i) System.out.print("P ");
                else System.out.print("x ");
            }
            System.out.println();
        }
    }
}
