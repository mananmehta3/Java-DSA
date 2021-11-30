package com.company.LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        linkedLists list = new linkedLists();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);
        list.display();
        list.reverseBetween(2,4);
        list.display();
//        list.insertAtIndex(41,3);
//        System.out.println(list.deleteFirst());
//        list.display();
//        System.out.println(list.deleteLast());
//        list.display();
//        System.out.println(list.deleteAtIndex(1));
//        list.display();
//        System.out.println(list.find(6));
//        System.out.println(list.length());

//        doublyLinkedList list = new doublyLinkedList();
//        list.insertFirst(79);
//        list.insertFirst(3);
//        list.insertLast(67);
//        list.insertFirst(3234);
//        list.insertFirst(32);
//        list.insertFirst(5);
//        list.insertLast(72);
//        list.insertAtIndex(45, 100);
//        list.display();
//        System.out.println(list.size);
//        list.displayInReverse();

//        circularLinkedList list = new circularLinkedList();
//        list.insert(1);
//        list.insert(2);
//        list.insert(22);
//        list.insert(253);
//        list.display();
//        list.delete(22);
//        list.display();
//        list.delete(253);
//        list.display();
    }
}
