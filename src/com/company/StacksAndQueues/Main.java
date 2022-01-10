package com.company.StacksAndQueues;

public class Main {
    public static void main(String[] args) throws Exception {
        DynamicQueue queue = new DynamicQueue(5);
        queue.insert(42);
        queue.insert(452);
        queue.insert(2);
        queue.display();
        queue.insert(2);
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.insert(223);
        queue.remove();
        queue.insert(642);
        queue.remove();
        queue.insert(234);
        queue.insert(34);
        queue.insert(24);
        queue.insert(4);
        queue.insert(23);
        queue.insert(44);
        queue.remove();
        queue.insert(2334);
        queue.insert(2324);
        queue.insert(21);
        for (int i = 0; i < 100; i++) {
            queue.insert(i);
        }
        queue.display();
    }
}
