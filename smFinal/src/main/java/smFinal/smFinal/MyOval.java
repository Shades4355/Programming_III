// File name:   MyCircle
// Written by:  Shades Meyers
// Description: Creates a child of MyBoundedShape, an Oval,
//              that throws an error if it's given radius is negative
// Challenges:  Had to look up the Area and Perimeter formulas for an oval
// Time Spent:  13 min
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-May-02      SM      File copied from MyCircle and modified


package smFinal.smFinal;


public class MyOval extends MyBoundedShape {
    // private variables
    private double width, height;

    // constructors
    public MyOval() {
        super();
        width = 1.0;
        height = 1.0;
    }

    public MyOval(double width, double height) throws InvalidRadiusException {
        super();
        setWidth(width);
        setHeight(height);
    }

    public MyOval(double radius, String color, boolean filled) throws InvalidRadiusException {
        super(color, filled); // Call the MyBoundedShape constructor
        setWidth(width);
        setHeight(height);
    }

    // Accessor and Mutator
    // Width
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) throws InvalidRadiusException {
        if (width < 0) { // if radius is less than 0, throw exception
            throw new InvalidRadiusException();
        } else {
            this.width = width;
        }
    }

    // Height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws InvalidRadiusException {
        if (height < 0) { // if radius is less than 0, throw exception
            throw new InvalidRadiusException();
        } else {
            this.height = height;
        }
    }

    // Implemented methods from MyBoundedShape
    @Override
    public double getArea() {
        return Math.PI * (width / 2) * (height / 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((((width / 2) * (width / 2)) + ((height / 2) * (height / 2))) / 2);
    }

    // Implemented methods from Colorable
    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return String.format("[" + getName() + "]" + " width: %.1f, height: %.1f", width, height);
    }

    @Override
    public String howToDraw() {
        return super.toString();
    }

} // end of program