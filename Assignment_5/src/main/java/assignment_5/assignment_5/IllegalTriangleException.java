// File name:   IllegalTriangleException
// Written by:  Shades Meyers
// Description: a custom exception for when a triangle has illegal side lengths
// Challenges:  None
// Time Spent:  0 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-16    SM      Copied from Assignment 2


package assignment_5.assignment_5;


public class IllegalTriangleException extends Exception {
    
    // Constructors
    public IllegalTriangleException() {
        super("Invalid triangle: Sum of any two sides is not greater than the third side.");
    }
    public IllegalTriangleException(double side1, double side2, double side3, String error) {
        super("Invalid triangle: " + error
                + "\nSide 1: " + Double.toString(side1)
                + "\nSide 2: " + Double.toString(side2)
                + "\nSide 3: " + Double.toString(side3));
    }

} // end program