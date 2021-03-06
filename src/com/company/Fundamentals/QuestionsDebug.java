package com.company.Fundamentals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class QuestionsDebug {
    public static void main(String[] args) throws java.lang.Exception {
        // int[] arr = {3, 5, 9};
        // System.out.println(isPossible(arr));
        strongElements();
    }

    public static void strongElements() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int gcd = arr[0];
            for (int i = 1; i < n; i++) {
                gcd = arr[i] % gcd;
            }
            if (gcd != 0) System.out.println(0);
            else System.out.println(n);
        }
    }

    public static void isPossible() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int p = sc.nextInt();
            int x = p % 100;
            int n = p / 100;
            if (n > 10) {
                System.out.println(-1);
                // continue;
            } else if (n == 10) {
                if (x == 0) System.out.println(10);
                else System.out.println(-1);
            } else {
                if ((x > 10) || ((x + n) > 10)) System.out.println(-1);
                else System.out.println(x + n);
            }
        }
    }

    public static char slowestKey(int[] rT, String kP) {
        char maxChar = kP.charAt(0), currChar;
        int maxT = rT[0], currT;
        for (int i = 1; i < rT.length; i++) {
            currT = rT[i] - rT[i - 1];
            currChar = kP.charAt(i);
            if (currT >= maxT) {
                if (currT == maxT) maxChar = currChar > maxChar ? currChar : maxChar;
                else maxChar = currChar;
                maxT = currT;
            }
        }
        return maxChar;
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int currL = 1, maxL = 1;
        StringBuilder subS = new StringBuilder();
        subS.append(s.charAt(0));
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            String temp = Character.toString(c);
            if (subS.indexOf(temp) == -1) {
                subS.append(temp);
                currL++;
            } else {
                int x = subS.indexOf(temp);
                subS.delete(1, x + 1);
                currL = subS.length();
            }
            maxL = Math.max(maxL, currL);
        }
        return maxL;
    }


    public static int firstMissingPositive(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]) {
                swap(arr, i, correct);
            } else {
                i++;
            }
        }
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index + 1) {
                return index + 1;
            }
        }
        return arr.length + 1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int match(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == i + 1) return i;
        }
        return -1;
    }

    public static int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        // System.out.println(Arrays.toString(arr));
        for (int i = n - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] - arr[j] == k) {
                    count++;
                    // System.out.println(i + " "+ j + " "+count+" ");
                }
            }
        }
        for (int j : arr) {
            if (j == k) count++;
        }
        return count;
    }

    public static int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int currL = 0, maxL = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push('(');
            else if (s.charAt(i) == ')') {
                if (!st.isEmpty() && st.peek() == '(') {
                    currL += 2;
                    st.pop();
                }
                if (currL > maxL) maxL = currL;
                else if (st.isEmpty()) currL = 0;
            }
        }
        return maxL;
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            digits.addAll(helper(new ArrayList<>(), low, high, i));
        }
        Collections.sort(digits);
        return digits;
    }

    static List<Integer> helper(List<Integer> digits, int l, int h, int i) {
        if (i >= l && i <= h) {
            digits.add(i);
        }
        if (i > h) return digits;
        int x = (i % 10) + 1;
        i = (i * 10) + x;
        return helper(digits, l, h, i);
    }

    public static String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        st.push(s.charAt(0));
        for (int i = 1; i < n; i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i)) {
                st.pop();
            } else st.push(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.peek());
            st.pop();
        }
        return ans.reverse().toString();
    }

    public static int solve(int[] arr, int B) {
        int s = 1, e = arr.length;
        if (arr[e - 1] <= B) return arr.length;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid - 1] <= B) s = mid + 1;
            else e = mid;
        }
        return s - 1;
    }

    static int binAsc(int[] arr, int s, int e, int t) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == t) return mid;
            else if (arr[mid] > t) e = mid - 1;
            else s = mid + 1;
        }
        return -1;
    }

    static int binDes(int[] arr, int s, int e, int t) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == t) return mid;
            else if (arr[mid] > t) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }

    public static String convert(String s, int n) {
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = "";
        }
        int count = 0;
        int l = s.length();
        int i = 0, j = -1;
        while (i < l) {
            if (count % 2 == 0) j++;
            else j--;
            if (j >= 0 && j < n) ans[j] += (s.charAt(i));
            i++;
            if (j == n - 1) {
                count++;
            }
            if (j == 0 && count != 0) {
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
