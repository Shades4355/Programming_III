// File name:   MyCircle
// Written by:  Shades Meyers
// Description: a circle subclass of MyBoundedShape;
//              has an additional radius variable
// Challenges:  None
// Time Spent:  see TestMyBoundedShapes.java
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Jan-23  SM      Files created


public class MyCircle extends MyBoundedShape {
    // private variables
    private double radius;

    // constructors
    public MyCircle() {
        super();
        radius = 1.0;
    }
    public MyCircle(double radius) {
        super();
        this.radius = radius;
    }
    public MyCircle(double radius, String color, boolean filled) {
        super(color, filled);    // Call the MyBoundedShape constructor
        this.radius = radius;
    }

    // print method
    public void printCircle() {
        System.out.println(
            "The circle is created " + getDateCreated() +
            "\nthe radius is " + String.format("%.1f", getRadius())
            );
    }

    // Accessor and Mutator for Radius
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Circle specific method
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    public double getDiameter() {
        return 2 * radius;
    }
}
