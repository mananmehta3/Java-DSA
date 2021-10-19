package com.company;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {34, 31, 14, 4, 32, 3, 244, 3234};
        mergeSortInPlace(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSortInPlace(int[] arr, int s, int e) {
        if (e - s == 1) return;
        int mid = (s + e) / 2;
        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);
        mergeInPlace(arr, s, mid, e);
    }

    static void mergeInPlace(int[] arr, int s, int m, int e) {
        int[] mix = new int[e - s];
        int i = s, j = m, k = 0;
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                k++;
                i++;
            } else {
                mix[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i < m) {
            mix[k] = arr[i];
            k++;
            i++;
        }
        while (j < e) {
            mix[k] = arr[j];
            k++;
            j++;
        }
        System.arraycopy(mix, 0, arr, s, mix.length);
    }

    static int[] merge(int[] first, int[] second) {
        int[] mix = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mix[k] = first[i];
                k++;
                i++;
            } else {
                mix[k] = second[j];
                k++;
                j++;
            }
        }
        while (i < first.length) {
            mix[k] = first[i];
            k++;
            i++;
        }
        while (j < second.length) {
            mix[k] = second[j];
            k++;
            j++;
        }
        return mix;
    }

    static int[] mergeSortFunc(int[] arr) {
        if (arr.length == 1) return arr;
        int mid = arr.length / 2;
        int[] left = mergeSortFunc(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSortFunc(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }
}
