package com.company;

public class recursion {
    public static void main(String[] args) {
        System.out.println(fibbonacci(6));
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
