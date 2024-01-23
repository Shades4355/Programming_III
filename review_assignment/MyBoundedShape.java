// File name:   MyBoundedShape
// Written by:  Shades Meyers
// Description: 
// Challenges:  
// Time Spent:  see TestMyBoundedShapes.java
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Jan-23  SM      Files created

import java.util.Date;


public class MyBoundedShape {
    // protected variables - using protected instead of private so they can be accessed by their inheritors
    protected String color = "white";   // color string (ex: red)
    protected boolean filled = false;   // whether it's filled or not
    protected Date dateCreated;         // date it was created

    // Constructors
    public MyBoundedShape() {
        dateCreated = new Date();
    }
    public MyBoundedShape(String c, boolean f) {
        dateCreated = new Date();
        color = c;
        filled = f;
    }

    // toString()
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
        }

    // Accessors and mutators, grouped variable
    // Color
    public String getColor(){
        return color;
    }
    public void setColor(String c) {
        color = c;
    }

    // Filled
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean f) {
        filled = f;
    }

    // Date Created; no setter
    public Date getDateCreated() {
        return dateCreated;
    }
}