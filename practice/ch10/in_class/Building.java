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

    @Override
    public void getCarbonFootprint() {
        System.out.println("Building: Y per square foot\nSquare Feet: %d".formatted(squareFeet));
    }

}