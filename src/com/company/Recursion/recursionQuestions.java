package com.company.Recursion;

public class recursionQuestions {
    public static void main(String[] args) {
        int n = 505192010;
//        System.out.println(reverseNumber(n, (int)(Math.pow(10,(int)Math.log10(n)))));
        System.out.println(countNumberOfZeroes(n,0));
    }

    static int countNumberOfZeroes(int n, int count){
        if(n==0) return count;
        if(n%10==0) return countNumberOfZeroes(n/10,++count);
        else return countNumberOfZeroes(n/10,count);
    }

    static boolean isPalindrome(int n){
        if(n==reverseNumber(n,(int)(Math.pow(10,(int)Math.log10(n))))) return true;
        return false;
    }

    static int reverseNumber(int n, int m) {
        if (n == 0) return 0;
        return (n % 10) * m + reverseNumber(n / 10, m / 10);
    }

    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumOfDigits(n / 10);
    }

    public static int sumOfnNumbers(int n) {
        if (n < 1) return 0;
        return n + sumOfnNumbers(n - 1);
    }

    public static int factorialOfANumber(int n) {
        if (n <= 1) return 1;
        return n * factorialOfANumber(n - 1);
    }

    public static void printNum(int n) {
        if (n == 0) return;
        printNum(n - 1);
        System.out.print(n + " ");
    }
}
