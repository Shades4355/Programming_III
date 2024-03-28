// File name:   GeometricObject.cpp
// Written by:  Shades Meyers
// Description: An abstract parent class for various shapes
// Challenges:  None
//                  
// Time Spent:   5 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created


#include "GeometricObject.h"


GeometricObject::GeometricObject() {
    color = "white";
    filled = true;
}

GeometricObject::GeometricObject(string color, bool filled) {
    this->color = color;
    this->filled = filled;
}

string GeometricObject::getColor() const {
    return color;
}

void GeometricObject::setColor(string color) {
    this->color = color;
}

bool GeometricObject::isFilled() const {
    return filled;
}

void GeometricObject::setFilled(bool filled) {
    this->filled = filled;
}

string GeometricObject::toString() {
    return "GeometricObject";
}

