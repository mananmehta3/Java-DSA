package com.company.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// d-> diagonal , D-> Down, R-> Right, U-> Up, L-> Left
// 0-> open path, 1-> obstacle

public class backtracking {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 1, 1, 0}
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}
        };
        char[][] sol = new char[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sol[i][j] = 'o';
            }
        }
        printingPathWithObstacleAllowingAllDirectionPrint(arr, 0, 0, "", sol);
    }

    static void print2D(char[][] path) {
        for (char[] chars : path) {
            System.out.println(Arrays.toString(chars));
        }
    }

    static void printingPathWithObstacleAllowingAllDirectionPrint(int[][] arr, int r, int c, String a, char[][] path) {
        if (r == arr.length - 1 && c == arr[0].length - 1 && arr[r][c]==0) {
            path[r][c] = 'x';
            print2D(path);
            System.out.println(a);
            System.out.println();
            return;
        }
        if (arr[r][c] == 1) return;
        arr[r][c] = 1;
        path[r][c] = 'x';
        if (r < arr.length - 1) printingPathWithObstacleAllowingAllDirectionPrint(arr, r + 1, c, a + 'D', path);
        if (c < arr[0].length - 1) printingPathWithObstacleAllowingAllDirectionPrint(arr, r, c + 1, a + 'R', path);
        if (r > 0) printingPathWithObstacleAllowingAllDirectionPrint(arr, r - 1, c, a + 'U', path);
        if (c > 0) printingPathWithObstacleAllowingAllDirectionPrint(arr, r, c - 1, a + 'L', path);
        arr[r][c] = 0;
        path[r][c] = 'o';
    }

    static List<String> printingPathWithObstacleAllowingAllDirection(int[][] arr, int r, int c, String a) {
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            List<String> temp = new ArrayList<>();
            temp.add(a);
            return temp;
        }
        List<String> sol = new ArrayList<>();
        if (arr[r][c] == 1) return sol;
        arr[r][c] = 1;
        if (r < arr.length - 1) sol.addAll(printingPathWithObstacleAllowingAllDirection(arr, r + 1, c, a + 'D'));
        if (c < arr[0].length - 1) sol.addAll(printingPathWithObstacleAllowingAllDirection(arr, r, c + 1, a + 'R'));
        if (r > 0) sol.addAll(printingPathWithObstacleAllowingAllDirection(arr, r - 1, c, a + 'U'));
        if (c > 0) sol.addAll(printingPathWithObstacleAllowingAllDirection(arr, r, c - 1, a + 'L'));
        arr[r][c] = 0;
        return sol;
    }

    static List<String> printingPathWithObstacle(int[][] arr, int r, int c, String a) {
        if (r == arr.length - 1 && c == arr[0].length - 1) {
            List<String> temp = new ArrayList<>();
            temp.add(a);
            return temp;
        }
        List<String> sol = new ArrayList<>();
        if (arr[r][c] == 1) return sol;
        if (r < arr.length - 1) sol.addAll(printingPathWithObstacle(arr, r + 1, c, a + 'D'));
        if (c < arr[0].length - 1) sol.addAll(printingPathWithObstacle(arr, r, c + 1, a + 'R'));
        return sol;
    }

    static List<String> printingPathAllowDiagonal(int r, int c, String a) {
        if (r == 1 && c == 1) {
            List<String> temp = new ArrayList<>();
            temp.add(a);
            return temp;
        }
        List<String> ans = new ArrayList<>();
        if (r == 1) ans.addAll(printingPathAllowDiagonal(r, c - 1, a + 'R'));
        else if (c == 1) ans.addAll(printingPathAllowDiagonal(r - 1, c, a + 'D'));
        else {
            ans.addAll(printingPathAllowDiagonal(r - 1, c - 1, a + 'd'));
            ans.addAll(printingPathAllowDiagonal(r - 1, c, a + 'D'));
            ans.addAll(printingPathAllowDiagonal(r, c - 1, a + 'R'));
        }
        return ans;
    }

    static List<String> printingPath(int r, int c, String a) {
        if (r == 1 && c == 1) {
            List<String> temp = new ArrayList<>();
            temp.add(a);
            return temp;
        }
        List<String> ans = new ArrayList<>();
        if (r == 1) ans.addAll(printingPath(r, c - 1, a + 'R'));
        else if (c == 1) ans.addAll(printingPath(r - 1, c, a + 'D'));
        else {
            ans.addAll(printingPath(r - 1, c, a + 'D'));
            ans.addAll(printingPath(r, c - 1, a + 'R'));
        }
        return ans;
    }

    static void printingPathVoidFunc(int r, int c, String a) {
        if (r == 1 && c == 1) {
            System.out.print(a + " ");
            return;
        }
        if (r == 1) printingPathVoidFunc(r, c - 1, a + 'R');
        else if (c == 1) printingPathVoidFunc(r - 1, c, a + 'D');
        else {
            printingPathVoidFunc(r - 1, c, a + 'D');
            printingPathVoidFunc(r, c - 1, a + 'R');
        }
    }

    static int countingPaths(int r, int c) {
        if (r == 1) return 1;
        if (c == 1) return 1;
        return countingPaths(r - 1, c) + countingPaths(r, c - 1);
    }
}
