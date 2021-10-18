package com.company;

import java.util.Arrays;

public class binarySearch2DArray {
    public static void main(String[] args) {
        int arr[][] = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        System.out.println(Arrays.toString(search(arr, 17)));
    }

    static int[] binarySearch(int[][] mat, int r, int cS, int cE, int t) {
        while (cS <= cE) {
            int mid = cS + (cE - cS) / 2;
            if (mat[r][mid] == t) return new int[]{r, mid};
            else if (mat[r][mid] > t) cE = mid - 1;
            else cS = mid + 1;
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] mat, int t) {
        int r = mat.length;
        int c = mat[0].length;
        if (c == 0) return new int[]{-1, -1};
        if (r == 1) return binarySearch(mat, 0, 0, c - 1, t);
        int rS = 0, rE = r - 1, cM = c / 2;
        while (rS < (rE - 1)) {
            int mid = rS + (rE - rS) / 2;
            if (mat[mid][cM] == t) return new int[]{mid, cM};
            else if (mat[mid][cM] > t) rE = mid;
            else rS = mid;
        }
        if (mat[rS][cM] == t) return new int[]{rS, cM};
        if (mat[rS + 1][cM] == t) return new int[]{rE, cM};
        if (t <= mat[rS][cM - 1]) return binarySearch(mat, rS, 0, cM - 1, t);
        if (t >= mat[rS][cM + 1] && t <= mat[rS][c - 1]) return binarySearch(mat, rS, cM + 1, c - 1, t);
        if (t <= mat[rS + 1][cM - 1]) return binarySearch(mat, rS + 1, 0, cM - 1, t);
        else return binarySearch(mat, rS + 1, cM + 1, c - 1, t);
    }
}