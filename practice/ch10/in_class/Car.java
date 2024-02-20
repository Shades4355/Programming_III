// File name:   Car
// Written by:  Shades Meyers
// Description: A car class with overridden getCarbonFootprint() method
// Challenges:  None
// Time Spent:  A couple minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-06  SM      File created


public class Car implements CarbonFootprint {
    private double gallons;

    public Car(double gallons) {
        this.gallons = gallons;
    }
    
    // one gallon of gas yields 20 pounds of CO2
    // http://www.enviroduck.com/carbon_footprint_calculations.php
    @Override
    public void getCarbonFootprint() {
        System.out.printf("Car that has used %.2f gallons of gas: %.2f\n",
                gallons, gallons * 20);
    }

}
