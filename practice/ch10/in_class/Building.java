// File name:   Building
// Written by:  Shades Meyers
// Description: A building class with square footage and an overridden getCarbonFootprint() method
// Challenges:  None
// Time Spent:  A couple minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-06  SM      File created


public class Building implements CarbonFootprint {
    private int squareFeet;

    public Building (int sf) {
        squareFeet = sf;
    }

    // Simplified formula: Multiply the square footage by 50
    // for the wood frame, by 20 for the basement,
    // by 47 for the concrete, and 17 for the steel
    // Note: The website where we got this information no longer exists.
    @Override
    public void getCarbonFootprint() {
        System.out.printf("Building with %d square feet: %d\n",
                squareFeet, squareFeet * (50 + 20 + 47 + 17));
    }

}