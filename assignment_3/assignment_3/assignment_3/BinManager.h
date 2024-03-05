// File name:   BinManager.h
// Written by:  Shades Meyers
// Description: A class for managing Bin objects (header)
// Challenges:  When using pointers; program terminates on launch
// Time Spent:  9 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-04  SM      File created
// 2024-Mar-05  SM      Added "nullptr" to bins[9] variable


#ifndef BINMANAGER_H
#define BINMANAGER_H

#include "InvBin.h"

class BinManager {
private:
    InvBin* bins[9] = {nullptr, nullptr , nullptr , nullptr , nullptr , nullptr , nullptr , nullptr , nullptr};

public:
    // Constructor
    BinManager();

    // Destructor
    ~BinManager();

    // Class functions
    void displayReport() const;
    void addItemsToBin(int, int);
    void removeItemFromBin(int, int);

}; // end class

#endif 

