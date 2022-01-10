package com.company.StacksAndQueues;

import java.util.*;

public class StackAndQueueCollectionFramework {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(32);
        stack.push(34);
        stack.push(35);
        stack.push(53);
        stack.push(36);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(54);
        queue.add(64);
        queue.add(53);
        queue.add(42);
        queue.add(43);
        System.out.println(queue.remove() + " " + queue.peek());

        System.out.println();

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(81);
        deque.addLast(34);
        deque.removeFirst();
        System.out.println(deque.peekLast());
    }
}
