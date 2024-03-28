// File name:   GeometricObject.h
// Written by:  Shades Meyers
// Description: The Header for an abstract parent class
//                  for various shapes
// Challenges:  None
//                  
// Time Spent:   5 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created


#ifndef GEOMETRICOBJECT_H

#define GEOMETRICOBJECT_H


#include <string>
using namespace std;


class GeometricObject {
private:
    string color;
    bool filled;

protected:
    // Constructors
    GeometricObject();
    GeometricObject(string color, bool filled);

public:
    // Destructor
    virtual ~GeometricObject() {};

    // Accessors and Mutators
    // Color
    string getColor() const;
    void setColor(string color);
    
    // Filled
    bool isFilled() const;
    void setFilled(bool filled);

    // toString override
    string toString();

    // Abstract functions
    virtual double getArea() const = 0;
    virtual double getPerimeter() const = 0;
}; // end GeometricObject class

#endif // end definition

