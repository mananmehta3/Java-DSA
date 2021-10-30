package com.company.Recursion;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {24, 235, 24, 5, 2, 3, 25, -34, 25, 52, 0, -525, -25};
        quickSortFunc(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSortFunc(int[] arr, int l, int h) {
        if (l > h) return;
        int s = l;
        int e = h;
        int m = s + (e - s) / 2;
        int pivot = arr[m];
        while(s<=e){
            while(arr[s]<pivot) s++;
            while(arr[e]>pivot) e--;
            if(s<=e){
                int temp = arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        quickSortFunc(arr,l,e);
        quickSortFunc(arr,s,h);
    }
}
