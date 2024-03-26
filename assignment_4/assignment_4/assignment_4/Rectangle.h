// File name:   Rectangle.h
// Written by:  Shades Meyers
// Description: The Header for a Rectangle class
// Challenges:  None
//                  
// Time Spent:   5 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Added exception class


#ifndef RECTANGLE_H
#define RECTANGLE_H


#include "GeometricObject.h"


class Rectangle : public GeometricObject {
private:
    double width;
    double height;

public:
    // Exception class
    class InvalidSide {};

    // Constructors
    Rectangle();
    Rectangle(double width, double height);
    Rectangle(double width, double height, string color, bool filled);

    // Destructor
    ~Rectangle();

    // Accessors and Mutators
    // Width
    double getWidth() const;
    void setWidth(double width);

    // Height
    double getHeight() const;
    void setHeight(double height);

    // Area
    virtual double getArea() const override;

    // Perimeter
    virtual double getPerimeter() const override;

}; // end Rectangle class

#endif

