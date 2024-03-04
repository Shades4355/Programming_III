// File name:   BinManager.cpp
// Written by:  Shades Meyers
// Description: A class for managing Bin objects
// Challenges:  Formatting Report display to meet expectations
// Time Spent:  23 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-04  SM      File created


#include "BinManager.h"
#include <iostream>
using namespace std;


// Constructor
BinManager::BinManager() {
    InvBin bins[9] = {
        InvBin("regular pliers", 25),
        InvBin("n. nose pliers", 5),
        InvBin("screwdriver", 25),
        InvBin("p. head screw driver", 6),
        InvBin("wrench-large", 7),
        InvBin("wrench-small", 18),
        InvBin("drill", 51),
        InvBin("cordless drill", 16),
        InvBin("hand saw", 12)
    };
} // end Constructor

// Destructor
BinManager::~BinManager() {
    delete [] bins;
} // end Destructor

// Class functions
void BinManager::displayReport() const {
    // prints out a report showing bin number, description of bin, and 
    // quantity in bin

    cout << "Bin Report:" << endl;
    cout << "____________________________________________" << endl;
    cout << "Bin\t\tPart\t\t\t\tQty" << endl;
    cout << "____________________________________________" << endl;
    for (int i = 0; i < sizeof(bins); i++) {
        cout << i << "\t\t" << bins[i].getDescription() << "\t\t\t\t" << bins[i].getQuantity() << endl;
    } // end For loop
    cout << "____________________________________________" << endl;
} // end Function

void BinManager::addItemsToBin(int bin, int amount) {
    bins[bin].addItem(amount);
} // end Function

void BinManager::removeItemFromBin(int bin, int amount) {
    bins[bin].removeItem(amount);
} // end Function

