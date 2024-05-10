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

public class MyLine extends MyRectangle {
    public MyLine() {
        height = 0;
        width = 10;
    }
    @Override
    public String getName() { return "Line"; }

    @Override
    public String toString() {
        return String.format("[" + getName() + "] length: %.1f", width);
    }

    @Override
    public String howToDraw() {
        return getName() + "'s color: %s".formatted(Color.web(String.format("rgb(%s)", color)));
    }
}
