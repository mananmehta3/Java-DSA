package com.company.StacksAndQueues;

public class StaticStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int ptr = -1;

    public StaticStack() {
        this(DEFAULT_SIZE);
    }

    public StaticStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) return false;
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot pop from an empty stack!");
        }
        return data[ptr--];
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Cannot peek from an empty stack!");
        }
        return data[ptr];
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr >= data.length - 1;
    }
}
