// File name:   MyBoundedShape
// Written by:  Shades Meyers
// Description: an abstract Superclass used for defining Subclasses (shapes)
// Challenges:  None
// Time Spent:  5 min
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-30    SM      Copied file from Assignment 5
// 2024-May-03      SM      Added accessors and mutators for Color and Filled


package smFinal.smFinal;

import java.util.Date;
import javafx.scene.paint.Color;


public abstract class MyBoundedShape implements Colorable, Comparable<MyBoundedShape> {
     // protected variables
    protected String color = "255, 255, 255";   // color string
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

    // Accessors and Mutators
    // Color
    public void setColor(int red, int green, int blue) {
        color = String.format("%d, %d, %d", red, green, blue);
    }
    public String getColor() {
        return color;
    }

    // Filled

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public boolean isFilled() {
        return filled;
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
        return getName() + "'s color: %s and filled: %b".formatted(Color.web(String.format("rgb(%s)", color)), filled);
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
