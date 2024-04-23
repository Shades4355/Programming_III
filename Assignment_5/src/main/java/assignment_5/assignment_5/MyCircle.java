// File name:   MyCircle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Circle,
//              that throws an error if it's given radius is negative
// Challenges:  None
// Time Spent:  3 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-16    SM      MyCircle copied from Assignment 2
// 2024-April-18    SM      Added getShape(); removed toString override
// 22024-April-22   SM      Removed getShape(); updated howToDraw()


package assignment_5.assignment_5;


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
        setRadius(radius);
    }

    public MyCircle(double radius, String color, boolean filled) throws InvalidRadiusException {
        super(color, filled); // Call the MyBoundedShape constructor
        setRadius(radius);
    }

    // Accessor and Mutator for Radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws InvalidRadiusException {
        if (radius < 0) { // if radius is less than 0, throw exception
            throw new InvalidRadiusException(radius);
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
        return String.format("[" + getName() + "]" + " radius: %.1f", radius);
    }

} // end of program