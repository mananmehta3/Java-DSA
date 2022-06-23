package com.company.Fundamentals;

import java.util.Arrays;
// import java.util.Scanner;

public class cyclicSort {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        int[] arr = {11,12,13,3,4,2,1,5,8,6,7,10,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr){
        int i = 0;
        while(i<arr.length){
            int correct = arr[i]-1;
            if(arr[i]==arr[correct]) i++;
            else{
                int temp = arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }
        }
    }
}