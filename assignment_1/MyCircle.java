// File name:   MyCircle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Circle.
// Challenges:  None
// Time Spent:  10 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-05  SM      File created
//                      Copied and modified contents of MyCircle.java from Review Assignment


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
        super(color, filled); // Call the MyBoundedShape constructor
        this.radius = radius;
    }

    // Accessor and Mutator for Radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Implemented methods from MyBoundedShape
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // Implemented methods from Colorable
    public String getName() {
        return "Circle";
    }

    public String howToDraw() {
        return "Color with radius";
    }

    // Overrides
    @Override
    public String toString() {
        return super.toString() + "%n%d.1f".formatted(radius);
    }

} // end of program