package com.company.LinkedList;

public class linkedLists {

    private Node head;
    private Node tail;
    private int size;

    public linkedLists() {
        size = 0;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int length() {
        return size;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            size++;
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        if (head == null) head = tail;
        size++;
    }

    public void insertAtIndex(int val, int i) {
        if (i == 0) {
            insertFirst(val);
            size++;
            return;
        }
        if (i == size) {
            size++;
            insertLast(val);
            return;
        }
        Node temp = head;
        while (i-- > 1) {
            temp = temp.next;
        }
        temp.next = new Node(val, temp.next);
        size++;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public int find(int value){
        Node node = head;
        int count = 0;
        while(node!=null){
            if(node.val==value) return count;
            node = node.next;
            count++;
        }
        return -1;
    }

    public int deleteAtIndex(int i) {
        if (i == 0) return deleteFirst();
        if (i == size - 1) return deleteLast();
        Node prev = get(i);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public int deleteLast() {
        if (size <= 1) return deleteFirst();
        Node secondLast = get(size - 2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public Node get(int i) {
        Node node = head;
        while (i-- > 1) node = node.next;
        return node;
    }

    public int deleteFirst() {
        int val = head.val;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
