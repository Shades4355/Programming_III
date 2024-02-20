// File name: IllegalTriangleException
// Written by: Shades Meyers
// Description: a custom exception for when a triangle has illegal side lengths
// Challenges: None
// Time Spent: 8 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      File created


public class IllegalTriangleException extends Exception {
    
    // Constructors
    public IllegalTriangleException() {
        super("Invalid triangle: Sum of any two sides is not greater than the third side.");
    }
    public IllegalTriangleException(double side1, double side2, double side3, String error) {
        super("Invalid triangle: " + error);
    }

} // end program