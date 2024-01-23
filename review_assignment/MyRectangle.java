// File name:   MyRectangle
// Written by:  Shades Meyers
// Description: 
// Challenges:  
// Time Spent:  see TestMyBoundedShapes.java
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Jan-23  SM      Files created


public class MyRectangle extends MyBoundedShape {
    // private variables
    private double width;
    private double height;

    // constructors
    public MyRectangle() {
        width = 1.0;
        height = 2.0;
    }
    public MyRectangle(double w, double h) {
        width = w;
        height = h;
    }
    public MyRectangle(double w, double h, String c, boolean f) {
        super(c, f);
        width = w;
        height = h;
    }

    // Accessors and Mutators, grouped by variable
    // Width
    public double getWidth() {
        return width;
    }
    public void setWidth(double w) {
        width = w;
    }
    // Height
    public double getHeight() {
        return height;
    }
    public void setHeight(double h) {
        height = h;
    }

    // Rectangle specific methods
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
