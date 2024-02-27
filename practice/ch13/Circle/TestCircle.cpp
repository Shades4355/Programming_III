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

    while (radius <= 0) {
        cout << "\nEnter a radius (greater than 0):" << endl;
        cout << ">> ";
        cin >> radius;
    }
}