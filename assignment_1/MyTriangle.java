// File name:   MyTriangle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Triangle.
// Challenges:  None
// Time Spent:  12 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-05  SM      File created


public class MyTriangle extends MyBoundedShape {
    // Variables
    private double side1;
    private double side2;
    private double side3;

    // Constructors
    public MyTriangle() {
        new MyTriangle(1.0, 1.0, 1.0);
    }

    public MyTriangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public MyTriangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Implemented methods from MyBoundedShape
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;

        return Math.sqrt(s * (s-side1)*(s-side2)*(s-side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Implemented methods from Colorable
    public String getName() {
        return "Triangle";
    }

    public String howToDraw() {
        return "Color with three sides";
    }

    // Overrides
    @Override
    public String toString() {
        return super.toString() + "%nside1: %.1f side2: %.1f side3: %.1f".formatted(side1, side2, side3);
    }

} // end of program
