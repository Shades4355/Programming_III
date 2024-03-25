// File name:   Square.cpp
// Written by:  Shades Meyers
// Description: A Square class
// Challenges:  None
//                  
// Time Spent:   5 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created


#include "Square.h"
#include <iostream>
#include <iomanip>
using namespace std;


Square::Square() {
    side = 1.0;
}

Square::Square(double side) {
    setSide(side);
}

Square::Square(double side, string color, bool filled) : Rectangle(side, side, color, filled) {
    setSide(side);
}

Square::~Square() {
    cout << "The square object is destroyed." << endl;
}

double Square::getSide() const {
    return side;
}

void Square::setSide(double side) {
    if (side > 0) {
        this->side = side;
    } else {
        cout << setprecision(2) << fixed;
        cout << "You entered a side of: " << side << endl;
        cout << "Side will be set to 1.0" << endl;

        this->side = 1.0;
    }
}

double Square::getArea() const {
    return side * side;
}

double Square::getPerimeter() const {
    return 4 * side;
}

