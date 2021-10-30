package com.company.Recursion;

import java.util.Arrays;

public class recursionInPatterns {
    public static void main(String[] args) {
        int[] arr = {23, 43, 53, 535, 63, 25, 5};
        bubbleSort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
        int[] arr2 = {23, 43, 53, 35, 355, 464, 34, 55, 35, 30, 25, 5};
        selectionSort(arr2, arr2.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr2));
    }

    static void selectionSort(int[] arr, int n, int l, int i) {
        if (n == 0) return;
        if (i < n) {
            if (arr[i] > arr[l]) {
                selectionSort(arr, n, i, i + 1);
            } else selectionSort(arr, n, l, i + 1);
        } else {
            int temp = arr[i];
            arr[i] = arr[l];
            arr[l] = temp;
            selectionSort(arr, n - 1, 0, 0);
        }
    }

    static void bubbleSort(int[] arr, int n, int i) {
        if (n == 0) {
            return;
        }
        if (i < n) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
            bubbleSort(arr, n, i + 1);
        } else {
            bubbleSort(arr, n - 1, 0);
        }
    }

    static void triangle2(int r, int c) {
        if (r == 0) return;
        if (c < r) {
            triangle2(r, c + 1);
            System.out.print("* ");
        } else {
            triangle2(r - 1, 0);
            if (r != 1) System.out.println();
        }
    }

    static void triangle1(int r, int c) {
        if (r == 0) return;
        if (c < r) {
            System.out.print("* ");
            triangle1(r, c + 1);
        } else {
            System.out.println();
            triangle1(r - 1, 0);
        }
    }
}
