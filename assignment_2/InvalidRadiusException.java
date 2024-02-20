// File name: InvalidRadiusException
// Written by: Shades Meyers
// Description: a custom Exception for when a radius is invalid
// Challenges: None
// Time Spent: 4 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      File created


public class InvalidRadiusException extends Exception {
    
    // constructors
    public InvalidRadiusException() {
        super("ERROR: negative radius.");
    }
    public InvalidRadiusException(double radius) {
        super("Invalid radius: " + Double.toString(radius));
    }

} // end program
