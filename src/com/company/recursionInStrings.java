package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class recursionInStrings {
    public static void main(String[] args) {
        List<String> sol = subSetsAscii("", "ab");
        Collections.sort(sol);
        System.out.println(sol);
        int[] arr = {1, 3, 1, 2};
        Arrays.sort(arr);
        System.out.println(subSetIntWithoutDuplicate(arr));
    }

    static List<List<Integer>> subSetIntWithoutDuplicate(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int s = 0, e = 0;
        for (int i = 0; i < arr.length; i++) {
            s = 0;
            if (i > 0 && arr[i] == arr[i - 1]) s = e + 1;
            int n = ans.size();
            e = n - 1;
            for (int j = s; j < n; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }

    static List<List<Integer>> subSetInt(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i : arr) {
            int n = ans.size();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j));
                temp.add(i);
                ans.add(temp);
            }
        }
        return ans;
    }

    static List<String> subSetsAscii(String p, String up) {
        if (up.isEmpty()) {
            List<String> temp = new ArrayList<>();
            if (!p.isEmpty()) temp.add(p);
            return temp;
        }
        List<String> ans = new ArrayList<>();
        ans.addAll(subSetsAscii(p, up.substring(1)));
        ans.addAll(subSetsAscii(p + up.charAt(0), up.substring(1)));
        ans.addAll(subSetsAscii(p + ((int) up.charAt(0)), up.substring(1)));
        return ans;
    }

    static List<String> subSets(String p, String up) {
        if (up.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        List<String> ans = new ArrayList<>();
        ans.addAll(subSets(p, up.substring(1)));
        ans.addAll(subSets(p + up.charAt(0), up.substring(1)));
        return ans;
    }

    static String skipAWhenNotB(String p, String A, String B, String up) {
        if (up.isEmpty()) {
            return p;
        }
        if (up.startsWith(A) && !up.startsWith(B)) return skipAWhenNotB(p, A, B, up.substring(A.length()));
        else {
            char ch = up.charAt(0);
            if (ch == ' ') ch = '_'; // to visualise space better
            return skipAWhenNotB(p + ch, A, B, up.substring(1));
        }
    }

    static String skipAWord(String p, String word, String up) {
        if (up.isEmpty()) {
            return p;
        }
        if (up.startsWith(word)) return skipAWord(p, word, up.substring(word.length()));
        else {
            char ch = up.charAt(0);
            return skipAWord(p + ch, word, up.substring(1));
        }
    }

    static String skipAChar(String s, int i, char c) {
        if (i >= s.length()) return s;
        if (s.charAt(i) == c) return skipAChar(s.substring(0, i) + s.substring(i + 1), i + 1, c);
        return skipAChar(s, i + 1, c);
    }

    static void permutations(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        int n = p.length();
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, n);
            permutations(f + ch + s, up.substring(1));
        }
    }

    static int permutationsCount2(String s) {
        int x = 1;
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            x *= i;
        }
        return x;
    }

    static int permutationsCount1(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int n = p.length();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, n);
            count += permutationsCount1(f + ch + s, up.substring(1));
        }
        return count;
    }

    static List<String> permutationsList(String p, String up) {
        if (up.isEmpty()) {
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        char ch = up.charAt(0);
        int n = p.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, n);
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }
}
