// File name:   MyRectangle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, a Rectangle.
// Challenges:  Mentally slipped into GDScript; had trouble remembering the syntax for converting a double to a string.
// Time Spent:  24 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-05  SM      File created
//                      Copied and modified contents of MyRectangle.java from Review Assignment


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

    public MyRectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public MyRectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    // Accessors and Mutators, grouped by variable
    // Width
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Implemented methods from MyBoundedShape
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Implemented methods from Colorable
    public String getName() {
        return "Rectangle";
    }

    public String howToDraw() {
        return "Color with width and height";
    }

    // Overrides
    @Override
    public String toString() {
        return super.toString() + "%nwidth: %.1f and height: %.1f".formatted(width, height);
    }

} // end of program
