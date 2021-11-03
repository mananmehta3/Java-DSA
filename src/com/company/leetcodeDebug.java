package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcodeDebug {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5};
        System.out.println(combinationSum(arr, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> nums = new ArrayList<>();
        return cSum(candidates, target, 0, nums);
    }

    static List<List<Integer>> cSum(int[] arr, int t, int i, List<Integer> nums) {
        if (t == 0) {
            List<List<Integer>> temp = new ArrayList<>();
            temp.add(nums);
            return temp;
        }
        if (i == arr.length) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        if (arr[i] <= t) {
            nums.add(arr[i]);
            t -= arr[i];
            ans.addAll(cSum(arr, t, i, nums));
        }
        return ans;
    }

    public static int findComplement(int num) {
        String x = Integer.toBinaryString(num);
        // System.out.print(x);
        int ans = 0;
        int multiplier = 1;
        int n = x.length();
        for (int i = n - 1; i >= 0; i--) {
            if (x.charAt(i) == '0') ans += (multiplier);
            multiplier *= 2;
        }
        return ans;
    }

    public static String longestDupSubstring(String s) {
        int n = s.length();
        System.out.println(n);
        String ans = "";
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    StringBuilder sol = new StringBuilder();
                    int x = i, y = j, count = 0;
                    while (y < n && s.charAt(x) == s.charAt(y)) {
                        sol.append(s.charAt(x));
                        x++;
                        y++;
                        count++;
                    }
                    if (count > maxCount) {
                        ans = sol.toString();
                        maxCount = count;
                    }
                }
            }
        }
        System.out.println(ans.length());
        return ans;
    }

    public static int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int temp = i;
            while (temp > 0) {
                arr[i] += (temp & 1);
                temp >>= 1;
            }
        }
        return arr;
    }

    static int maxRepeating(String s, String word) {
        int n = s.length();
        int m = word.length();
        int c = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s.charAt(i), c2 = word.charAt(0);
            if (c1 == c2) {
                int x = 1;
                while (x < m && s.charAt(i + x) == word.charAt(x)) {
                    x++;
                }
                if (x == m) {
                    c++;
                    i += (m - 1);
                }
            }
        }
        return c;
    }

    public static int oddCells(int m, int n, int[][] mat) {
        int[][] arr = new int[m][n];
        int x = mat.length;
        for (int[] ints : mat) {
            int temp = ints[0];
            for (int j = 0; j < n; j++) {
                arr[temp][j]++;
            }
        }
        print2D(arr);
        for (int[] ints : mat) {
            int temp = ints[1];
            for (int j = 0; j < m; j++) {
                arr[j][temp]++;
            }
        }
        print2D(arr);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] % 2 == 1) count++;
            }
        }
        return count;
    }

    public static void print2D(int[][] mat) {
        // Loop through all rows
        for (int[] ints : mat) {
            // Loop through all elements of current row
            for (int anInt : ints) System.out.print(anInt + " ");
            System.out.println();
        }
    }
}