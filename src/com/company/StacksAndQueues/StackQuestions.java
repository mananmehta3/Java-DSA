package com.company.StacksAndQueues;

import java.util.Stack;

public class StackQuestions {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 4);
        reverseAStack(s);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }

    private static void reverseAStack(Stack<Integer> s) {
        if (s.isEmpty()) return;
        int x = s.peek();
        s.pop();
        reverseAStack(s);
        pushAtBottom(s, x);
    }

    private static void pushAtBottom(Stack<Integer> s, int i) {
        if (s.isEmpty()) {
            s.push(i);
            return;
        }
        int x = s.peek();
        s.pop();
        pushAtBottom(s, i);
        s.push(x);
    }
}
