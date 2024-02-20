// File name:   MyCircle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Circle,
//              that throws an error if it's given radius is negative
// Challenges:  None
// Time Spent:  5 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      MyCircle copied from Assignment 1, and modified according to Assignment 2


public class MyCircle extends MyBoundedShape {
    // private variables
    private double radius;

    // constructors
    public MyCircle() {
        super();
        radius = 1.0;
    }

    public MyCircle(double radius) throws InvalidRadiusException {
        super();
        setRadius(radius);;
    }

    public MyCircle(double radius, String color, boolean filled) {
        super(color, filled); // Call the MyBoundedShape constructor
        this.radius = radius;
    }

    // Accessor and Mutator for Radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws InvalidRadiusException {
        if (radius < 0) { // if radius is less than 0, throw exception
            throw new InvalidRadiusException();
        } else {
            this.radius = radius;
        }
    }

    // Implemented methods from MyBoundedShape
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // Implemented methods from Colorable
    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String howToDraw() {
        return "Color with radius";
    }

    // Overrides
    @Override
    public String toString() {
        return super.toString() + "%nradius: %.1f".formatted(radius);
    }

} // end of program