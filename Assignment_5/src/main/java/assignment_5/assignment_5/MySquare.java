// File name:   MySquare
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Square,
//              which throws an exception if its side is less than or equal to 0
// Challenges:  None
// Time Spent:  2 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-16    SM      Copied from Assignment 2
// 2024-April-18    SM      Added getShape(); removed toString override
// 2024-April-22    SM      Removed getShape(); updated howToDraw()
// 2024-April-23    SM      updated howToDraw method and toString method



package assignment_5.assignment_5;


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
        throw new IllegalArgumentException("Side must be greater than 0.0.");
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
    public String toString() {
        return String.format("[" + getName() + "] side: %.1f", side);
    }

    @Override
    public String howToDraw() {
        return super.toString();
    }

} // end of program
