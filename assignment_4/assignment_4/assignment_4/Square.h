// File name:   Square.h
// Written by:  Shades Meyers
// Description: The Header for a Square class
// Challenges:  None
//                  
// Time Spent:   3 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created


#ifndef SQUARE_H
#define SQUARE_H

#include "Rectangle.h"


class Square :
    public Rectangle {
private:
    double side;

public:
    // Constructors
    Square();
    Square(double side);
    Square(double side, string color, bool filled);

    // Destructor
    ~Square();

    // Accessors and Mutators
    // Side
    double getSide() const;
    void setSide(double side);

    // Area
    virtual double getArea() const override;

    // Perimeter
    virtual double getPerimeter() const override;

}; // end Square class

#endif