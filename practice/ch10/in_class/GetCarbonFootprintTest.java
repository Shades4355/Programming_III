// File name:   GetCarbonFootprintTest
// Written by:  Shades Meyers
// Description: Calls getCarbonFootprint() on 3 different Classes
// Challenges:  None
// Time Spent:  A couple minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-06  SM      File created


import java.util.ArrayList;

public class GetCarbonFootprintTest {
    public static void main(String[] args) {
        // Instantiate our 3 classes
        Building building = new Building(200);
        Car car = new Car(50);
        Bicycle bike = new Bicycle();

        // Create an ArrayList and add above classes to said list
        ArrayList<CarbonFootprint> carbonList = new ArrayList<CarbonFootprint>();
        carbonList.add(building);
        carbonList.add(car);
        carbonList.add(bike);

        // Iterate through list and print out getCarbonFootprint() for each item
        System.out.println("");
        for (CarbonFootprint item: carbonList) {
            item.getCarbonFootprint();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("");
        }
    } // end Main
} // end program
