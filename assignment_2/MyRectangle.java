// File name:   MyRectangle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Rectangle,
//              which throws an error if its height and/or width is invalid
// Challenges:  None
// Time Spent:  6 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      Copied and modified contents of MyRectangle.java from Assignment 1


public class MyRectangle extends MyBoundedShape {
    // private variables
    private double width;
    private double height;

    // constructors
    public MyRectangle() {
        super();
        width = 1.0;
        height = 2.0;
    }

    public MyRectangle(double width, double height) throws IllegalArgumentException {
        super();
        setWidth(width);
        setHeight(height);
    }

    public MyRectangle(double width, double height, String color, boolean filled) throws IllegalArgumentException {
        super(color, filled);
        setWidth(width);
        setHeight(height);
    }

    // Accessors and Mutators, grouped by variable
    // Width
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) throws IllegalArgumentException {
        if (width <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.width = width;
        }
    }

    // Height
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) throws IllegalArgumentException {
        if (height <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.height = height;
        }
    }

    // Implemented methods from MyBoundedShape
    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Implemented methods from Colorable
    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public String howToDraw() {
        return "Color with width and height";
    }

    // Overrides
    @Override
    public String toString() {
        return super.toString() + "%nwidth: %.1f and height: %.1f".formatted(width, height);
    }

} // end of program
