// File name:   TestCircle.cpp
// Written by:  Shades Meyers
// Description: A Circle class
// Challenges:  
// Time Spent:  11 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-27  SM      File created
// 2024-Feb-28  SM      Build failed - troubleshooting
//                      Started new project; copied previous files
//                      Build working - 1 or more files were in the 
//                          wrong place


#include "Circle.h";
#include <iostream>

using namespace std;

int main() {
    double radius = 0;

    while (radius <= 0) { // input validation
        cout << "Enter a radius:" << endl;
        cout << ">> ";
        cin >> radius;

        if (radius <= 0) {
            radius = 0;
            cout << "Please enter a number greater than 0." << endl;
        }
    }

    Circle circle1 = Circle(radius);
    Circle circle2 = Circle();

    cout << "Your circle has a radius of " << circle1.getRadius() << endl;
    cout << "Mine has a radius of " << circle2.getRadius() << endl;

    cout << "Your circle has an area of " << circle1.getArea() << endl;
    cout << "Mine has an area of " << circle2.getArea() << endl;

    cout << "Your circle has a circumference of " << circle1.getCircumference() << endl;
    cout << "Mine has a circumference of " << circle2.getCircumference() << endl;

    cout << "Your circle has a diameter of " << circle1.getDiameter() << endl;
    cout << "Mine has a diameter of " << circle2.getDiameter() << endl;

    cout << "\nGoodbye!" << endl;
    cout << "Press [enter] to exit program: "
}