package com.company.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class Stacks {
    private static class stackArray {
        private final int[] arr;
        private int i = 0;
        private final int size;

        public stackArray(int n) {
            this.arr = new int[n];
            this.size = n;
        }

        public void push(int v) {
            if (i >= size) {
                System.out.println("Stack is full");
                return;
            }
            arr[i] = v;
            i++;
        }

        public void pop() {
            if (i <= 0) {
                System.out.println("Stack is empty");
                return;
            }
            i--;
        }

        public int peek() {
            if (i <= 0 || i >= size) return -1;
            return arr[i - 1];
        }
    }

    private static class stackLinkedList {
        static class Node {
            int data;
            Node next;

            public Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        Node head;

        public stackLinkedList() {
            head = null;
        }

        public void push(int i) {
            if (head == null) {
                head = new Node(i);
                return;
            }
            Node newNode = new Node(i);
            newNode.next = head;
            head = newNode;
        }

        public void pop() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return;
            }
            head = head.next;
        }

        public int peek() {
            if (head == null) return -1;
            return head.data;
        }
    }

    private static class stackArrayList {
        ArrayList<Integer> list;
        int size = 0;

        public stackArrayList() {
            list = new ArrayList<>();
        }

        public void push(int i) {
            list.add(i);
            size++;
        }

        public void pop() {
            if(size==0) {
                System.out.println("Stack Empty");
                return;
            }
            list.remove(size-1);
            size--;
        }

        public int peek() {
            return list.get(size-1);
        }
    }

    public static void main(String[] args) {
        // stackArrayList s = new stackArrayList();
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.peek());
        s.push(42);
        s.push(432);
        s.push(354);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        s.push(10);
        System.out.println(s.peek());
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.peek());
        s.pop();
        s.push(35);
        s.push(5);
        System.out.println(s.peek());
    }
}
