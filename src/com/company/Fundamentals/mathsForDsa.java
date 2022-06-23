package com.company.Fundamentals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mathsForDsa {
    public static void main(String[] args) {
//        int n = 4;
//        int[] arr = {3, 3, 2, 2, 3, 2, 4, 4, 3, 2, 50, 4, 4};
//        System.out.println(findUnique(arr, n));
//        System.out.println(euclidAlgorithmToFindGCD(36000, 1800));
        System.out.println(sqrt(100));
    }

    static int LCM(int a, int b) {
        return a * b / euclidAlgorithmToFindGCD(a, b);
    }

    static int euclidAlgorithmToFindGCD(int a, int b) {
        if (a == 0) return b;
        else return euclidAlgorithmToFindGCD(b % a, a);
    }

    static List<Integer> factors(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) ans.add(i);
                else {
                    ans.add(i);
                    ans.add(n / i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

    static double sqrt(double n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + n / x);
            if (Math.abs(root - x) <= 0.1) break;
            x = root;
        }
        return root;
    }

    static List<Integer> sieve(int n) {
        List<Integer> sol = new ArrayList<>();
        if (n <= 1) return sol;
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i += 1) {
            if (arr[i] == 0) {
                sol.add(i);
                for (int j = i * i; j <= n; j += i) {
                    if (j % i == 0) arr[j] = 1;
                }
            }
        }
        return sol;
    }

    static int findXOROfAtoB(int a, int b) {
        return findXOROf0toN(b) ^ findXOROf0toN(a - 1);
    }

    static int findXOROf0toN(int a) {
        if (a % 4 == 0) return a;
        if (a % 4 == 1) return 1;
        if (a % 4 == 2) return a + 1;
        return 0;
    }

    static int noOfSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    static int easyPower(int a, int b) {
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans *= a;
            b >>= 1;
            a *= a;
        }
        return ans;
    }

    static boolean isPowerOfTwo(int n) {
        return (n & n - 1) == 0;
    }

    static int SumOfNthRowInPascalTriangle(int n) {
        if (n == 0) return 0;
        return 1 << n;
    }

    static int nthMagicNumber(int n, int x) {
        int temp = n;
        int ans = 0;
        int multiFactor = x;
        while (temp > 0) {
            int bit = temp & 1;
            ans += (multiFactor * bit);
            temp >>= 1;
            multiFactor *= x;
        }
        return ans;
    }

    static int findUnique(int[] arr, int n) {
        // n -> no. of repetitions
        int[] bit = new int[64];
        for (int i : arr) {
            int temp = i;
            int p = 0;
            while (temp > 0) {
                int lastBit = temp & 1;
                bit[p] += lastBit;
                p++;
                temp >>= 1;
            }
        }
        int m = 1, ans = 0;
        for (int i = 0; i < 64; i++) {
            bit[i] %= n;
            // System.out.print(bit[i]+" ");
            ans += (m * bit[i]);
            m *= 2;
        }
        return ans;
    }

    static int positionOfRightMostSetBit(int n) {
        int count = 1;
        while (n > 0) {
            int temp = n & 1;
            if (temp == 1) break;
            else {
                n = n >> 1;
                count++;
            }
        }
        if (n == 0) return 0;
        return 1 << (count - 1);
    }

    static int resetIthBit(int num, int n) {
        int mask = ~(1 << (n - 1));
        return num & mask;
    }

    static int setBit(int num, int n) {
        int mask = 1 << (n - 1);
        return num | mask;
    }

    static int getIthBit(int num, int n) {
        int a = 1 << (n - 1);
        int x = num & a;
        return x >> (n - 1);
    }

    static int unique(int[] arr) {
        // int n = arr.length;
        int ans = 0;
        for (int i : arr) {
            ans = ans ^ i;
        }
        return ans;
    }

    static boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}
