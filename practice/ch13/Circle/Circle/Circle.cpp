// File name:   Circle.cpp
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
using namespace std;


// Constructors
Circle::Circle() {
    radius = 0.0;
}
Circle::Circle(double r) {
    radius = r;
}

// Muttators and Accessors
// Radius
void Circle::setRadius(double r) {
    radius = r;
}
double Circle::getRadius() const {
    return radius;
}

// Area
double Circle::getArea() const {
    return (PI * radius * radius);
}

// Diameter
double Circle::getDiameter() const {
    return (radius * 2);
}

// Circumference
double Circle::getCircumference() const {
    return (2 * PI * radius);
}
