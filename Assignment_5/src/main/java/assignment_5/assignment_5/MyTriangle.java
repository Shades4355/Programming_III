// File name:   MyTriangle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Triangle,
//              which throws an exception if it has an invalid side
// Challenges:  None
// Time Spent:  1 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-16    SM      Copied from Assignment 2
// 2024-April-18    SM      Added getShape(); removed toString override


package assignment_5.assignment_5;


public class MyTriangle extends MyBoundedShape {
    // Variables
    private double side1;
    private double side2;
    private double side3;

    // Constructors
    public MyTriangle() throws IllegalTriangleException, IllegalArgumentException {
        this(1.0, 1.0, 1.0);
    }

    public MyTriangle(double side1, double side2, double side3) throws IllegalTriangleException, 
            IllegalArgumentException {
        super();
        setSides(side1, side2, side3);
    }

    public MyTriangle(double side1, double side2, double side3, String color, boolean filled) 
            throws IllegalTriangleException, IllegalArgumentException {
        super(color, filled);
        setSides(side1, side2, side3);
    }

    // Accessor and Mutator
    // No Accessor; just a Mutator
    public void setSides(double side1, double side2, double side3) throws IllegalTriangleException, IllegalArgumentException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalArgumentException("All sides must be positive numbers.");
        } else if (side1 + side2 <= side3 || side2 + side3 <= side1 || side3 + side1 <= side2) {
            throw new IllegalTriangleException(side1, side2, side3, "Sum of any two sides is not greater than the third side.");
        } else {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
    }

    // Implemented methods from MyBoundedShape
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;

        return Math.sqrt(s * (s-side1)*(s-side2)*(s-side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Implemented methods from Colorable
    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public String howToDraw() {
        return "Color with three sides";
    }

    // Overrides
    @Override
    public String getShape() {
        return String.format("[" + getName() + "] Side1 = %.1f, Side2 = %.1f, Side3 = %.1f",side1, side2, side3);
    }

} // end of program
