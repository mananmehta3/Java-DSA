package com.company.OOP;

import static com.company.OOP.Pen.count;

public class oops {
    public static void main(String[] args) {
        System.out.println(count);
        Pen pen1 = new Pen("yellow","glitter");
        Pen pen2 = new Pen();
        System.out.println(count);
        Pen pen3 = new Pen(pen1);
        pen1.printType();
        pen2.printType();
        pen3.printColor();
        System.out.println(count);
        oops temp = new oops();
        temp.temp();
    }

    void temp() {
        greeting();
    }

    static void greeting() {
        System.out.println("Hello");
    }
}