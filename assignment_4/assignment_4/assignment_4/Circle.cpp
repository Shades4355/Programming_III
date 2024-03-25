// File name:   GeometricObject.cpp
// Written by:  Shades Meyers
// Description: A Circle class
// Challenges:  None
//                  
// Time Spent:  8 min 
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created


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
        cout << setprecision(2) << fixed;
        cout << "You entered a radius of: " << radius << endl;
        cout << "Radius will be set to 1.0" << endl;

        this->radius = 1.0;
    }
}

double Circle::getDiameter() const {
    return radius * 2;
}

double Circle::getArea() const {
    return 3.14 * radius * radius;
}

double Circle::getPerimeter() const {
    return 2 * 3.14 * radius;
}
