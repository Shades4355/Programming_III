// File name:   MySquare
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Square,
//              which throws an exception if its side is less than or equal to 0
// Challenges:  None
// Time Spent:  0 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-30    SM      Copied file from Assignment 5


package smFinal.smFinal;


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
