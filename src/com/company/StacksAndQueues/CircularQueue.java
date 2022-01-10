package com.company.StacksAndQueues;

public class CircularQueue {
    public int[] data;
    private static final int DEFAULT_SIZE = 10;
    protected int end = 0;
    protected int front = 0;
    private int size = 0;

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean isFull() {
        return size >= data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean insert(int item) {
        if (isFull()) return false;
        data[end++] = item;
        size++;
        end = (end + data.length) % data.length;
        return true;
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty!");
        }
        int removed = data[front++];
        front = (front + data.length) % data.length;
        size--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is Empty!");
        }
        return data[front];
    }

    public void display() {
        if (isEmpty()) System.out.println("Queue is Empty!");
        int i = front;
        int x = size;
        while (x-- > 0) {
            System.out.print(data[i++] + " -> ");
            i = (i + size) % size;
        }
        System.out.println("Circular Queue Repeat");
    }
}
