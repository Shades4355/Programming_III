// File name:   GeometricObject.cpp
// Written by:  Shades Meyers
// Description: An abstract parent class for various shapes
// Challenges:  
//                  
// Time Spent:  
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
    color = color;
    filled = filled;
}

string GeometricObject::getColor() const {
    return string();
}

void GeometricObject::setColor(string color) {

}

bool GeometricObject::isFilled() const {
    return false;
}

void GeometricObject::setFilled(bool filled) {

}

string GeometricObject::toString()
{
    return string();
}

