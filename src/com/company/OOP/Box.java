package com.company.OOP;

public class Box {
    double l;
    double h;
    double w;

    public Box() {
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    // Cube
    public Box(double s) {
        this.l = s;
        this.h = s;
        this.w = s;
    }

    public Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    public Box(Box old) {
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }

    public void information() {
        System.out.println("Running the Box");
    }
}
