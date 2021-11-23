package com.company.LinkedList;

public class doublyLinkedList {

    private Node head;
    private Node tail;
    public int size = 0;

    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        node.prev = tail;
        node.next = null;
        tail.next = node;
        tail = node;
        size++;
    }

    public void insertAtIndex(int val, int i) {
        if (i <= 0) {
            insertFirst(val);
            return;
        }
        if (i >= size) {
            insertLast(val);
            return;
        }
        Node temp = head;
        for (int j = 1; j < i; j++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        node.prev = temp;
        temp.next = node;
        node.next.prev = node;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public void display() {
        Node temp = head;
        System.out.print("NULL <-> ");
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void displayInReverse() {
        Node temp = tail;
        System.out.print("NULL <-> ");
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
