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


#include "Rectangle.h"
#include <iostream>
#include <iomanip>
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
        cout << setprecision(2) << fixed;
        cout << "You entered a width of: " << width << endl;
        cout << "Width will be set to 1.0" << endl;
        
        this->width = 1.0;
    }
}

double Rectangle::getHeight() const {
    return height;
}

void Rectangle::setHeight(double height) {
    if (height > 0) {
        this->height = height;
    } else {
        cout << setprecision(2) << fixed;
        cout << "You entered a height of: " << height << endl;
        cout << "Height will be set to 1.0" << endl;

        this->height = 1.0;
    }
}

double Rectangle::getArea() const {
    return width * height;
}

double Rectangle::getPerimeter() const {
    return 2 * (width + height);
}



