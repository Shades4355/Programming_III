// File name:   MySquare
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Square.
// Challenges:  None
// Time Spent:  13 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-05  SM      File created
// 2024-Feb-6   SM      Added '@Override' to implementations. IDE shows errors from this, but the files compile and run correctly


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
