// File name:   GeometricObject.cpp
// Written by:  Shades Meyers
// Description: The header for an abstract parent class
//                  for various shapes
// Challenges:  
//                  
// Time Spent:  
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
    GeometricObject();
    GeometricObject(string color, bool filled);

public:
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
    double getArea() const;
    double getPermiter() const;
};

#endif // end definition

