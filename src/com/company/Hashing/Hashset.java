package com.company.Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(5);
        set.add(4);
        set.add(1);
        set.add(2);
        set.add(4);
        set.remove(2);
        set.add(6);
        set.add(9);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
