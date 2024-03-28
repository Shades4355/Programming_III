// File name:   GeometricObject.cpp
// Written by:  Shades Meyers
// Description: A Circle class
// Challenges:  None
//                  
// Time Spent:  9 min 
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Replaced input validation with 
//                      exception handling


#include "Circle.h"
#include <iostream>
#include <iomanip>
using namespace std;


Circle::Circle() {
    radius = 1.0;
}

Circle::Circle(double radius) {
    setRadius(radius);
}

Circle::Circle(double radius, string color, bool filled) : GeometricObject(color, filled) {
    setRadius(radius);
}

Circle::~Circle() {
    cout << "The circle object is destroyed." << endl;
}

double Circle::getRadius() const {
    return radius;
}

void Circle::setRadius(double radius) {
    if (radius > 0) {
        this->radius = radius;
    } else {
        throw InvalidRadius();
    }
}

double Circle::getDiameter() const {
    return radius * 2.0;
}

double Circle::getArea() const {
    return 3.14 * radius * radius;
}

double Circle::getPerimeter() const {
    return 2 * 3.14 * radius;
}
