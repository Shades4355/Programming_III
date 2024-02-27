// File name:   TestCircle.cpp
// Written by:  Shades Meyers
// Description: A Circle class
// Challenges:  
// Time Spent:  
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-27  SM      File created


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

    Circle circle1 = new Circle(radius);
    Circle circle2 = new Circle();


}