// File name:   InvBin.cpp
// Written by:  Shades Meyers
// Description: An Inventory Bin class file
// Challenges:  Forgot "endl" with my cout strings
// Time Spent:  24 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-04  SM      File created


#include "InvBin.h"
#include <iostream>
using namespace std;


// Constructors
InvBin::InvBin() {
    description = "empty";
    quantity = 0;
} // end function

InvBin::InvBin(string desc, int quant) {
    description = desc;
    quantity = quant;
} // end function


// Accessors and Mutators
void InvBin::setDescription(string desc) {
    description = desc;
} // end function

string InvBin::getDescription() const {
    return description;
} // end function

void InvBin::setQuantity(int quant) {
    quantity = quant;
} // end function

int InvBin::getQuantity() const {
    return quantity;
} // end function

// Additional functions
void InvBin::addItem(int amount) {

    // validate input
    if (amount < 1) {
        cout << "Invalid quantity. Please enter a positive number." << endl;
    } else { // if valid, apply
        quantity -= amount;

        // print number of items added to the bin
        cout << amount << " " << description << "(s) were added to the bin." << endl;
    } // end If/Else
} // end function

void InvBin::removeItem(int amount) {

    // validate input
    if (amount < 1) {
        cout << "Invalid quantity. Please enter a positive number." << endl;
    } else if (amount > quantity) {
            cout << "Cannot remove more items than the bin currently holds." << endl;
    } else {
        quantity -= amount;

        cout << amount << " " << description << "(s) removed from bin." << endl;
    } // end If/Else
} // end function

