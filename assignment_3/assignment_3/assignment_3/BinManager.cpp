// File name:   BinManager.cpp
// Written by:  Shades Meyers
// Description: A class for managing Bin objects
// Challenges:  Formatting Report display to meet expectations
//              InvBin was returning default Constructor instead
//                  of Constructor with arguements
//              When using pointers; program terminates on launch
//                  
// Time Spent:  43 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-04  SM      File created
// 2024-Mar-05  SM      Added For loop to Destructor
//                      Fixed Constructor (with Orobosa's help)
//                      Added ARRLEN to DRY up code


#include "BinManager.h"
#include <iostream>
#include <iomanip>
using namespace std;


// Constructor
BinManager::BinManager() {
    bins[0] = new InvBin("regular pliers", 25);
    bins[1] = new InvBin("n. nose pliers", 5);
    bins[2] = new InvBin("screwdriver", 25);
    bins[3] = new InvBin("p. head screw driver", 6);
    bins[4] = new InvBin("wrench-large", 7);
    bins[5] = new InvBin("wrench-small", 18);
    bins[6] = new InvBin("drill", 51);
    bins[7] = new InvBin("cordless drill", 16);
    bins[8] = new InvBin("hand saw", 12);
} // end Constructor

// Destructor
BinManager::~BinManager() {
    
    // deletes each bin
    for (int i = 0; i < ARRLEN; i++) {
        delete bins[i];
        bins[i] = nullptr;
    }
} // end Destructor

// Class functions
void BinManager::displayReport() const {
    // prints out a report showing bin number, description of bin, and 
    // quantity in bin

    cout << "Bin Report:" << endl;
    cout << "____________________________________________" << endl;
    cout << "Bin\t\tPart\t\t\tQty" << endl;
    cout << "____________________________________________" << endl;
    for (int i = 0; i < ARRLEN; i++) {
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

