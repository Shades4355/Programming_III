// File name:   InvBin.h
// Written by:  Shades Meyers
// Description: An Inventory Bin header file
// Challenges:  Initially used <String> instead of <string>
// Challenge 2: Type specifier "string" not recognized;
//                  Needed "using namespace std;"
// Time Spent:  14 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-04  SM      File created


#ifndef INVBIN_H
#define INVBIN_H

#include <string>
using namespace std;


class InvBin {
private:
    string description;
    int quantity;

public:
    // constructors
    InvBin();
    InvBin(string, int);

    // Accessors and Mutators
    //Description
    void setDescription(string);
    string getDescription() const;
    // Quantity
    void setQuantity(int);
    int getQuantity() const;

    // Additional functions
    void addItem(int);
    void removeItem(int);

}; // end class

#endif

