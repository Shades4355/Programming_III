// File name:   InvalidRadiusException
// Written by:  Shades Meyers
// Description: a custom Exception for when a radius is invalid
// Challenges:  None
// Time Spent:  0 minutes
//
// Revision history:
// Date:            By:     Action:
// -------------------------------
// 2024-April-16    SM      Copied from Assignment 2


package assignment_5.assignment_5;


public class InvalidRadiusException extends Exception {
    
    // constructors
    public InvalidRadiusException() {
        super("ERROR: negative radius.");
    }
    public InvalidRadiusException(double radius) {
        super("Invalid radius: " + Double.toString(radius));
    }

} // end program
