// File name:   Circle.h
// Written by:  Shades Meyers
// Description: The Header for a Circle class
// Challenges:  None
//                  
// Time Spent:   5 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Added exception class


#ifndef CIRCLE_H
#define CIRCLE_H


#include "GeometricObject.h"


class Circle : public GeometricObject {
private:
    double radius;

public:
    // Exception class
    class InvalidRadius {};

    // Constructors
    Circle();
    Circle(double radius);
    Circle(double radius, string color, bool filled);

    // Destructor
    ~Circle();

    // Accessors and Mutators
    // Radius
    double getRadius() const;
    void setRadius(double radius);

    // Diameter
    double getDiameter() const;

    // Area
    virtual double getArea() const override;

    // Perimeter
    virtual double getPerimeter() const override;

}; // end Circle class

#endif

