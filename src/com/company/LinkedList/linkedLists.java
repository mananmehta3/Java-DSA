package com.company.LinkedList;

public class linkedLists {

    private Node head;
    private Node tail;
    private int size;

    public linkedLists() {
        size = 0;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    public void reverseBetween(int l, int r) {
        reverseB(head, l, r);
    }

    private Node reverseB(Node head, int l, int r) {
        if (l == r) return head;
        Node c = head;
        Node p = null;
        for (int i = 0; c != null && i < l - 1; i++) {
            p = c;
            c = c.next;
        }
        Node lt = p;
        Node newE = c;
        Node nt = c;
        for (int i = 0; c != null && i < r - l; i++) {
            nt = nt.next;
        }
        assert nt != null;
        Node f = nt.next;
        nt.next = null;
        Node rs = reverse(c);
        lt.next = rs;
        for (int i = 0; i < r - l; i++) {
            rs = rs.next;
        }
        rs.next = f;
        return head;
    }

    private Node reverse(Node t) {
        if (t == null || t.next == null) return t;
        Node p = t;
        Node c = t.next;
        while (c != null) {
            Node r = c.next;
            c.next = p;
            p = c;
            c = r;
        }
        return p;
    }

    private void bubbleSort(int r, int c) {
        if (r == 0) return;
        if (c < r) {
            Node first = get(c);
            Node second = get(c + 1);
            if (first.val > second.val) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(c - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(c - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(r, c + 1);
        } else bubbleSort(r - 1, c);
    }

    public Node sort() {
        return sortList(head);
    }

    private Node sortList(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = middleNode(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return mergeTwoLists(left, right);
    }

    private Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Node ans;
        if (l1.val >= l2.val) {
            ans = l2;
            ans.next = mergeTwoLists(l1, l2.next);
        } else {
            ans = l1;
            ans.next = mergeTwoLists(l1.next, l2);
        }
        return ans;
    }

    private Node middleNode(Node head) {
        Node fast = head;
        Node slow = head;
        Node temp = slow;
        while (fast != null && fast.next != null) {
            temp = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        assert temp != null;
        temp.next = null;
        return slow;
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

    public void insertUsingRecursion(int val, int i) {
        head = insertRec(val, i, head);
    }

    private Node insertRec(int val, int i, Node node) {
        if (i == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertRec(val, i - 1, node.next);
        return node;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if (tail == null) tail = head;
        size++;
    }

    public int find(int value) {
        Node node = head;
        int count = 0;
        while (node != null) {
            if (node.val == value) return count;
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
