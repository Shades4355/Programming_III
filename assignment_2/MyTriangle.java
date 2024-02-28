// File name:   MyTriangle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Triangle,
//              which throws an exception if it has an invalid side
// Challenges:  None
// Time Spent:  12 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      Copied and updated MyTriangle from Assignment 1
//                      Added a Mutator for sides, so as to DRY up code
// 2024-Feb-26  SM      Fixed MyTriangle() constructor based on feedback from Assignment 1
// 2024-Feb-28  SM      Adjusted IllegalTriangleException call to be more
//                      inline with the spirit of the assignment.
//                      Added an exception for if a side is negative


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
    public String toString() {
        return super.toString() + "%nside1 = %.1f%nside2 = %.1f%nside3 = %.1f".formatted(side1, side2, side3);
    }

} // end of program
