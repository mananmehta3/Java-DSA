package com.company.LinkedList;

public class circularLinkedList {

    private Node head;
    private Node tail;
    public int size = 0;

    public void delete(int val) {
        Node node = head;
        if (node == null) {
            System.out.println("ELEMENT NOT PRESENT");
            return;
        }
        if (node.val == val) {
            tail.next = head.next;
            head = head.next;
            size--;
            return;
        }
        do {
            Node n = node.next;
            if (n.val == val) {
                node.next = n.next;
                size--;
                if (n == tail) tail = node;
                return;
            }
            node = node.next;
        } while (node != head);
        System.out.println("ELEMENT NOT PRESENT");
    }

    public void display() {
        Node temp = head;
        int s = 2 * size;
        while (s-- > 0) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("HEAD");
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    private class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
