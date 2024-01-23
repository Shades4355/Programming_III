// File name:   MyBoundedShape
// Written by:  Shades Meyers
// Description: Parent class to MyCircle and MyRectangle; contains color, filled, and dateCreated variables
// Challenges:  None
// Time Spent:  see TestMyBoundedShapes.java
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Jan-23  SM      Files created

import java.util.Date;


public class MyBoundedShape {
    // protected variables - using protected instead of private so they can be accessed by their inheritors more easily
    protected String color = "white";   // color string (ex: red)
    protected boolean filled = false;   // whether it's filled or not
    protected Date dateCreated;         // date it was created

    // Constructors
    public MyBoundedShape() {
        dateCreated = new Date();
    }
    public MyBoundedShape(String color, boolean filled) {
        dateCreated = new Date();
        this.color = color;
        this.filled = filled;
    }

    // toString()
    public String toString() {
        return "created on " + getDateCreated() + "\ncolor: " + getColor() + " \nfilled: " + isFilled();
        }

    // Accessors and Mutators, grouped variable
    // Color
    public String getColor(){
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    // Filled
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Date Accessor; no Mutator
    public Date getDateCreated() {
        return dateCreated;
    }
}