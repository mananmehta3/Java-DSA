package com.company.OOP;

public class Pen {

    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    String color;
    String type; // ballpoint, gel, glitter
    public static int count = 0;

    static {
        System.out.println("In static");
    }

    public Pen() {
        this("blue", "gel");
    }

    public Pen(Pen p) {
        this.color = p.color;
        this.type = p.type;
        Pen.count += 1;
    }

    public Pen(String color, String type) {
        this.color = color;
        this.type = type;
        Pen.count += 1;
    }

    public void printType() {
        System.out.println(this.type);
    }

    public void printColor() {
        System.out.println(this.color);
    }
}
