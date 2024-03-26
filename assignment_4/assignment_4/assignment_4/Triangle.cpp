// File name:   Triangle.cpp
// Written by:  Shades Meyers
// Description: A Triangle class
// Challenges:  None
//                  
// Time Spent:   11 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Replaced input validation with 
//                      exception handling


#include "Triangle.h"
#include <iostream>
#include <iomanip>
using namespace std;


Triangle::Triangle() {
    side1 = 1.0;
    side2 = 1.0;
    side3 = 1.0;
}

Triangle::Triangle(double side1, double side2, double side3) {
    setSide1(side1);
    setSide2(side2);
    setSide3(side3);
}

Triangle::Triangle(double side1, double side2, double side3, string color, bool filled) : GeometricObject(color, filled) {
    setSide1(side1);
    setSide2(side2);
    setSide3(side3);
}

Triangle::~Triangle() {
    cout << "The triangle object is destroyed." << endl;
}

double Triangle::getSide1() const
{
    return side1;
}

void Triangle::setSide1(double side1) {
    if (side1 > 0) {
        this->side1 = side1;
    } else {
        throw InvalidSide();
    }
}

double Triangle::getSide2() const {
    return side2;
}

void Triangle::setSide2(double side2) {
    if (side2 > 0) {
        this->side2 = side2;
    }
    else {
        cout << setprecision(2) << fixed;
        cout << "You entered a side for side2 of: " << side2 << endl;
        cout << "Side2 will be set to 1.0" << endl;

        this->side2 = 1.0;
    }
}

double Triangle::getSide3() const {
    return side3;
}

void Triangle::setSide3(double side3) {
    if (side3 > 0) {
        this->side3 = side3;
    }
    else {
        cout << setprecision(2) << fixed;
        cout << "You entered a side for side3 of: " << side3 << endl;
        cout << "Side3 will be set to 1.0" << endl;

        this->side3 = 1.0;
    }
}

double Triangle::getArea() const {
    double s = (side1 + side2 + side3) / 2;

    return sqrt(s * (s- side1) * (s - side2) * (s - side3));
}

double Triangle::getPerimeter() const
{
    return side1 + side2 + side3;
}
