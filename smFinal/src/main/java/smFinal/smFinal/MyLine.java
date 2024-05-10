// File name:   MyLine
// Written by:  Shades Meyers
// Description: Creates a child of MyRectangle, a Line,
//              which throws an error if its height and/or width is invalid
// Challenges:  None
// Time Spent:  1 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-May-10      SM      File created


 package smFinal.smFinal;


import javafx.scene.paint.Color;

public class MyLine extends MyBoundedShape {
    double length;
    public MyLine() {
        length = 1;
    }
    public MyLine(double len){
        super();
        length = len;
    }

    public MyLine(double len, String color, boolean filled) {
        super(color, filled);
        length = len;
    }

    // Accessors and Mutators
    // Length
    public double getLength() {
        return length;
    }
    public void setLength(double len) throws IllegalArgumentException {
        if (len >= 0) {
            length = len;
        } else {
            throw new IllegalArgumentException("Length must be greater than or equal to 0.0");
        }
    }

    @Override
    public String getName() { return "Line"; }

    @Override
    public String toString() {
        return String.format("[" + getName() + "] length: %.1f", length);
    }

    @Override
    public String howToDraw() {
        return getName() + "'s color: %s".formatted(Color.web(String.format("rgb(%s)", color)));
    }

    @Override
    public double getPerimeter() { return 0; }

    @Override
    public double getArea() { return 0; }
}
