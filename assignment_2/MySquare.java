// File name:   MySquare
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Square,
//              which throws an exception if its side is less than or equal to 0
// Challenges:  None
// Time Spent:  5 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      Copied and modified contents of MySquare.java from Assignment 1
// 2024-Feb-28  SM      Moved Exception message from MyExceptionsTest to MySquare


public class MySquare extends MyBoundedShape {
    // variables
    private double side;

    // Constructors
    public MySquare() {
        super();
        side = 1.0;
    }

    public MySquare(double side) throws IllegalArgumentException {
        super();
        setSide(side);
    }

    public MySquare(double side, String color, boolean filled) throws IllegalArgumentException {
        super(color, filled);
        setSide(side);
    }

    // Accessors and Mutators
    public double getSide() {
        return side;
    }

    public void setSide(double side) throws IllegalArgumentException {
       if (side <= 0) {
        throw new IllegalArgumentException("Radius must be greater than 0.00.");
       } else {
           this.side = side;
       }
    }

    // Implemented methods from MyBoundedShape
    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    // Implemented methods from Colorable
    @Override
    public String getName() {
        return "Square";
    }

    @Override
    public String howToDraw() {
        return "Color with four sides";
    }

    // Overrides
    @Override
    public String toString() {
        return super.toString() + "%nside: %.1f".formatted(side);
    }

} // end of program
