package com.company;

import java.util.ArrayList;
import java.util.List;

public class recursionInStrings {
    public static void main(String[] args) {
        System.out.println(permutationsCount("", "abcd"));
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

    static int permutationsCount(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        char ch = up.charAt(0);
        int n = p.length();
        int count = 0;
        for (int i = 0; i <= n; i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, n);
            count += permutationsCount(f + ch + s, up.substring(1));
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
