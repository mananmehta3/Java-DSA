package com.company.Recursion;

import java.util.ArrayList;
import java.util.List;

public class recursionInArrays {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        List<Integer> ans = new ArrayList<>();
        System.out.println(rotatedBinarySearch(arr, 0, arr.length - 1, 0));
    }

    static int rotatedBinarySearch(int[] arr, int s, int e, int t) {
        if(s>e) return -1;
        int m = s + (e-s)/2;
        if(arr[m]==t) return m;
        if(arr[s]<=arr[m]){
            if(t>=arr[s] && t<=arr[m]) return rotatedBinarySearch(arr,s,m-1,t);
            else return rotatedBinarySearch(arr,s+1,e,t);
        }
        if(t>=arr[m] && t<=arr[e]) return rotatedBinarySearch(arr,m+1,e,t);
        return rotatedBinarySearch(arr,s,m-1,t);
    }

    static List<Integer> searchAllOcc2(int[] arr, int i, int t) {
        List<Integer> ans = new ArrayList<>();
        if (i == arr.length) return ans;
        if (arr[i] == t) ans.add(i);
        List<Integer> ansFromBelow = searchAllOcc2(arr, i + 1, t);
        ans.addAll(ansFromBelow);
        return ans;
    }

    static List<Integer> searchAllOcc(int[] arr, int i, int t, List<Integer> ans) {
        if (i == arr.length) return ans;
        if (arr[i] == t) ans.add(i);
        return searchAllOcc(arr, i + 1, t, ans);
    }

    static boolean isSorted(int[] arr, int i, int n) {
        if (n <= 1) return true;
        if (arr[i] > arr[i + 1]) return false;
        return isSorted(arr, i + 1, n - 1);
    }
}
