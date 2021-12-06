package com.company.OOP;

public class oop1 {
    public static void main(String[] args) {
        Pen pen1 = new Pen("black", "ballpoint");
        Pen pen2 = new Pen(pen1);
        pen1.printType();
        pen2.printType();
    }
}

class Pen {
    String color;
    String type; // ballpoint, gel

    public Pen() {
        this("blue", "gel");
    }

    public Pen(Pen p) {
        this.color = p.color;
        this.type = p.type;
    }

    public Pen(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public void printType() {
        System.out.println(this.type);
    }

    public void printColor() {
        System.out.println(this.color);
    }
}