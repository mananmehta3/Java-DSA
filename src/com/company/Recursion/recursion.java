package com.company.Recursion;

import java.util.ArrayList;
import java.util.List;

public class recursion {
    public static void main(String[] args) {
        System.out.println(dice("", 1).size());
    }

    static List<String> dice(String p, int r) {
        if (r == 0) {
            List<String> temp = new ArrayList<>();
            temp.add(p);
            return temp;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= r; i++) {
            ans.addAll(dice(p + i, r - i));
        }
        return ans;
    }

    static int fibbonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibbonacci(n - 1) + fibbonacci(n - 2);
    }

    static void printMessage(int n) {
        if (n == 0) return;
        System.out.println("Hello World");
        printMessage(n - 1);
    }

    static void printNumber(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        printNumber(n - 1);
    }
}
