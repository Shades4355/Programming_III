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
// 2024-Mar-26  SM      Removed Else portion of 
//                      input validation


#include "Square.h"
#include <iostream>
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
    }
}

double Square::getArea() const {
    return side * side;
}

double Square::getPerimeter() const {
    return 4 * side;
}

