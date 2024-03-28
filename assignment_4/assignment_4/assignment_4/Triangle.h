// File name:   Triangle.h
// Written by:  Shades Meyers
// Description: The Header for a Triangle class
// Challenges:  None
//                  
// Time Spent:   5 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Added exception classes


#ifndef TRIANGLE_H
#define TRIANGLE_H


#include "GeometricObject.h"


class Triangle : public GeometricObject {
private:
    double side1, side2, side3;

public:
    // Exception classes
    class InvalidSide {};
    class InvalidTriangle {};

    // Constructors
    Triangle();
    Triangle(double side1, double side2, double side3);
    Triangle(double side1, double side2, double side3, string color, bool filled);

    // Destructor
    ~Triangle();

    // Accessors and Mutators
    // Side 1
    double getSide1() const;
    void setSide1(double side1);

    // Side 2
    double getSide2() const;
    void setSide2(double side2);

    // Side 3
    double getSide3() const;
    void setSide3(double side3);

    // Area
    void testArea();
    virtual double getArea() const override;

    // Perimeter
    virtual double getPerimeter() const override;

}; // end Triangle class

#endif