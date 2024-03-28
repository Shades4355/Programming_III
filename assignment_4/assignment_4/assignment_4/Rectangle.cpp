// File name:   Rectangle.cpp
// Written by:  Shades Meyers
// Description: A Rectangle class
// Challenges:  None
//                  
// Time Spent:   16 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Replaced input validation with 
//                      exception handling


#include "Rectangle.h"
#include <iostream>
using namespace std;


Rectangle::Rectangle() {
    width = 1.0;
    height = 1.0;
}

Rectangle::Rectangle(double width, double height) {
    setWidth(width);
    setHeight(height);
}

Rectangle::Rectangle(double width, double height, string color, bool filled) : GeometricObject(color, filled) {
    setWidth(width);
    setHeight(height);
}

Rectangle::~Rectangle() {
    cout << "The rectangle object is destroyed." << endl;
}

double Rectangle::getWidth() const {
    return width;
}

void Rectangle::setWidth(double width) {
    if (width > 0) {
        this->width = width;
    }
    else {
        throw InvalidSide();
    }
}

double Rectangle::getHeight() const {
    return height;
}

void Rectangle::setHeight(double height) {
    if (height > 0) {
        this->height = height;
    } else {
        throw InvalidSide();
    }
}

double Rectangle::getArea() const {
    return width * height;
}

double Rectangle::getPerimeter() const {
    return 2 * (width + height);
}



