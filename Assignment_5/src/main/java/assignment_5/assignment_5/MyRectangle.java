// File name:   MyRectangle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Rectangle,
//              which throws an error if its height and/or width is invalid
// Challenges:  None
// Time Spent:  3 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-16    SM      Copied from Assignment 2
// 2024-April-18    SM      Added getShape(); removed toString override
//                          Updated Error message
// 22024-April-22   SM      Removed getShape(); updated howToDraw()


package assignment_5.assignment_5;


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
            throw new IllegalArgumentException("Width and Height must be greater than 0.");
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
            throw new IllegalArgumentException("Width and Height must be greater than 0.");
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
        return String.format("[" + getName() + "] width: %.1f and height: %.1f", width, height);
    }

} // end of program
