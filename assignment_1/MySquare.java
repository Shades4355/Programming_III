// File name:   MySquare
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Square.
// Challenges:  None
// Time Spent:  12 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-05  SM      File created


public class MySquare extends MyBoundedShape {
    // variables
    private double side;

    // Constructors
    public MySquare() {
        super();
        side = 1.0;
    }

    public MySquare(double side) {
        super();
        this.side = side;
    }

    public MySquare(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }

    // Accessors and Mutators
    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    // Implemented methods from MyBoundedShape
    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }

    // Implemented methods from Colorable
    public String getName() {
        return "Square";
    }

    public String howToDraw() {
        return "Color with four sides";
    }

    // Overrides
    @Override
    public String toString() {
        return super.toString() + "%nside: %.1f".formatted(side);
    }

} // end of program
