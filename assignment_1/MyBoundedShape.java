// File name:   MyBoundedShape
// Written by:  Shades Meyers
// Description: an abstract Superclass used for defining Subclasses (shapes)
// Challenges:  None
// Time Spent:  31 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-05  SM      File created
//                      Copied and modified contents of MyBoundedShape.java from Review Assignment


import java.util.Date;


public abstract class MyBoundedShape extends Object implements Colorable, Comparable<MyBoundedShape> {
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
        return "created on " + this.dateCreated + "\ncolor: %s and filled %b".formatted(this.color, this.filled);
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
