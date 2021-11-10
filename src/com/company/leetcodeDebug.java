package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcodeDebug {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }


    public static String convert(String s, int n) {
        String[] ans = new String[n];
        for(int i=0;i<n;i++){
            ans[i]="";
        }
        int count = 0;
        int l = s.length();
        int i = 0, j = -1;
        while(i<l){
            if(count%2==0) j++;
            else j--;
            if(j>=0 && j<n) ans[j]+=(s.charAt(i));
            i++;
            if(j==n-1){
                count++;
            }
            if(j==0 && count!=0){
                count++;
            }
        }
        StringBuilder sol = new StringBuilder();
        for (i = 0; i < n; i++) {
            sol.append(ans[i]);
        }
        return sol.toString();
    }

    static String findSum(String str1, String str2) {
        // Before proceeding further, make sure length
        // of str2 is larger.
        if (str1.length() > str2.length()) {
            String t = str1;
            str1 = str2;
            str2 = t;
        }

        // Take an empty String for storing result
        StringBuilder str = new StringBuilder();

        // Calculate length of both String
        int n1 = str1.length(), n2 = str2.length();

        // Reverse both of Strings
        str1 = new StringBuilder(str1).reverse().toString();
        str2 = new StringBuilder(str2).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++) {
            // Do school mathematics, compute sum of
            // current digits and carry
            int sum = ((str1.charAt(i) - '0') +
                    (str2.charAt(i) - '0') + carry);
            str.append((char) (sum % 10 + '0'));

            // Calculate carry for next step
            carry = sum / 10;
        }

        // Add remaining digits of larger number
        for (int i = n1; i < n2; i++) {
            int sum = ((str2.charAt(i) - '0') + carry);
            str.append((char) (sum % 10 + '0'));
            carry = sum / 10;
        }

        // Add remaining carry
        if (carry > 0)
            str.append((char) (carry + '0'));

        // reverse resultant String
        str = new StringBuilder(new StringBuilder(str.toString()).reverse().toString());
        return str.toString();
    }

    public static String multiply(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        String sum = "";
        for (int i = m - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder prevA = new StringBuilder();
            char ch = s2.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char c = s1.charAt(j);
                int temp = (ch - '0') * (c - '0') + carry;
                carry = temp / 10;
                temp %= 10;
                prevA.insert(0, (char) (temp + '0'));
            }
            if (carry > 0) {
                char man = (char) (carry + '0');
                prevA.insert(0, man);
            }
            int count = m - i - 1;
            while (count-- > 0) {
                prevA.append('0');
            }
            sum = findSum(sum, prevA.toString());
        }
        return sum;
    }

    public static char findKthBit(int n, int k) {
        String s = binaryString(n, "0");
        return s.charAt(k - 1);
    }

    static String binaryString(int n, String s) {
        if (n == 1) return s;
        return binaryString(n - 1, s + "1" + reverseInvert(s));
    }

    static String reverseInvert(String s) {
        StringBuilder st = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') st.append('0');
            else st.append('1');
        }
        return st.toString();
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