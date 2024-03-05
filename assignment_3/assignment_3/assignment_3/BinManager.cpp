// File name:   BinManager.cpp
// Written by:  Shades Meyers
// Description: A class for managing Bin objects
// Challenges:  Formatting Report display to meet expectations
//              InvBin was returning default Constructor instead
//                  of Constructor with arguements
//              When using pointers; program terminates on launch
// Time Spent:  41 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-04  SM      File created
// 2024-Mar-05  SM      Added For loop to Destructor


#include "BinManager.h"
#include <iostream>
#include <iomanip>
using namespace std;


// Constructor
BinManager::BinManager() {
    *bins[0] = InvBin("regular pliers", 25);
    *bins[1] = InvBin("n. nose pliers", 5);
    *bins[2] = InvBin("screwdriver", 25);
    *bins[3] = InvBin("p. head screw driver", 6);
    *bins[4] = InvBin("wrench-large", 7);
    *bins[5] = InvBin("wrench-small", 18);
    *bins[6] = InvBin("drill", 51);
    *bins[7] = InvBin("cordless drill", 16);
    *bins[8] = InvBin("hand saw", 12);
} // end Constructor

// Destructor
BinManager::~BinManager() {
    
    // deletes each bin
    for (int i = 0; i < 9; i++) {
        delete bins[i];
    }

    // deletes array
    delete *bins;
} // end Destructor

// Class functions
void BinManager::displayReport() const {
    // prints out a report showing bin number, description of bin, and 
    // quantity in bin

    cout << "Bin Report:" << endl;
    cout << "____________________________________________" << endl;
    cout << "Bin\t\tPart\t\t\tQty" << endl;
    cout << "____________________________________________" << endl;
    for (int i = 0; i < 9; i++) {
        cout << i + 1 << "\t\t" << left << setw(20) << bins[i]->getDescription() << "\t" << right << setw(3) << bins[i]->getQuantity() << endl;
    } // end For loop
    cout << "____________________________________________" << endl << endl;
} // end Function

void BinManager::addItemsToBin(int bin, int amount) {
    bins[bin]->addItem(amount);
} // end Function

void BinManager::removeItemFromBin(int bin, int amount) {
    bins[bin]->removeItem(amount);
} // end Function

