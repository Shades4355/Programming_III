// File name:   Circle.h
// Written by:  Shades Meyers
// Description: A Circle class header
// Challenges:  
// Time Spent:  5 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-27  SM      File created
// 2024-Feb-28  SM      Started new project; copied previous files


#ifndef CIRCLE_H
#define CIRCLE_H

class Circle {
private:
    double radius;
    const double PI = 3.141559;

public:
    Circle();
    Circle(double);
    void setRadius(double);
    double getRadius() const;
    double getArea() const;
    double getDiameter() const;
    double getCircumference() const;
};
#endif

