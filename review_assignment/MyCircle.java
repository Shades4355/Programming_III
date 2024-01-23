// File name:   MyCircle
// Written by:  Shades Meyers
// Description: 
// Challenges:  
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
        radius = 1.0;
    }
    public MyCircle(double r) {
        radius = r;
    }
    public MyCircle(double r, String c, boolean f) {
        super(c, f);    // Call the MyBoundedShape constructor
        radius = r;
    }

    // accessor and mutator for Radius
    public double getRadius() {
        return radius;
    }
    public void setRadius(double r) {
        radius = r;
    }

    // Circle specific method
    public double getArea() {
        return radius * radius * 3.14;
    }
    public double getPerimeter() {
        return 2 * radius * 3.14;
    }
    public double getDiameter() {
        return 2 * radius;
    }

    // print method
    public void printCircle() {
        System.out.println("The circle is created " + dateCreated + ", and the radius is " + String.format("%.1f", radius));
    }
}
