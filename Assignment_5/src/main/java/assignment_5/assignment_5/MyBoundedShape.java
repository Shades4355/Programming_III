// File name:   MyBoundedShape
// Written by:  Shades Meyers
// Description: an abstract Superclass used for defining Subclasses (shapes)
// Challenges:  None
// Time Spent:  4 min
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-16    SM      Copied file from Assignment 2 and modified
// 2024-April-18    SM      Added getName() and modified toString() and added getShape()
// 22024-April-22   SM      Removed getShape(); updated toString()


package assignment_5.assignment_5;

import java.util.Date;


public abstract class MyBoundedShape implements Colorable, Comparable<MyBoundedShape> {
     // protected variables
    protected String color = "white";   // color string
    protected boolean filled = false;   // whether it's filled or not
    protected Date dateCreated;         // date it was created

    // constructors
    public MyBoundedShape() {
        dateCreated = new Date();
    }
    public MyBoundedShape(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    // Class Functions
    public String getName() {
        return "MyBoundedShape";
    }

    // static methods
    public static MyBoundedShape max(MyBoundedShape o1, MyBoundedShape o2) {
        if (o1.compareTo(o2) >= 0) {
            return o1;
        } else {
            return o2;
        }
    }

    // abstract methods
    public abstract double getArea();
    public abstract double getPerimeter();

    // overrides
    @Override
    public boolean equals(Object o) {
        MyBoundedShape m = (MyBoundedShape) o;
        return getArea() == m.getArea();
    }

    @Override
    public String toString() {
        return getName() + "'s color: %s and filled: %b".formatted(color, filled);
    }

    // new methods
    public int compareTo(MyBoundedShape o) {
        if (getArea() > o.getArea()) {
            return 1;
        } else if (getArea() == o.getArea()) {
            return 0;
        } else {
            return -1;
        }
    }

} // end of program
