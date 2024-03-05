// File name:   InvBin.cpp
// Written by:  Shades Meyers
// Description: An Inventory Bin class file
// Challenges:  Build failed; forgot to declare functions before main()
// Time Spent:  1 hour 14 minutes
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-04  SM      File created


#include "BinManager.h"
#include <iostream>
using namespace std;


void displayMenu();
int getChoice(int);
void addParts(BinManager&);
void removeParts(BinManager&);
void displayBins(const BinManager&);
int getBinIndex();
int getQuantity();


int main() {
    BinManager inventory = BinManager(); // initiallize inventory
    int input;

    inventory.displayReport();

    while (true) {
        displayMenu();
        
        cout << "Enter your choice:" << endl << ">> ";
        // get and then validate input
        cin >> input;
        input = getChoice(input);

        switch (input) {
        case 1:
            addParts(inventory);
            break;
        case 2:
            removeParts(inventory);
            break;
        case 3:
            displayBins(inventory);
            break;
        case 4:
            displayBins(inventory);

            cout << "Goodbye" << endl;

            return 0; // exits program
        } // end Switch statement
    } // end While loop
} // end main()


void displayMenu() {
    cout << "\tInventory Control Menu" << endl << endl;
    cout << "1 - Add parts to a bin" << endl;
    cout << "2 - Remove parts from a bin" << endl;
    cout << "3 - Display bin status report" << endl;
    cout << "4 - Quit" << endl << endl;
} // end displayMenu()


int getChoice(int choice) {
    // Validates "choice" and prompts for a new number if the current one is out of bounds. Returns validated number

    int val = choice;

    while (true) {
        if (val > 0 && val < 5) {
            return val;
        } else {
            cout << "Choice must be between 1 and 4. Please try again." << endl << ">> ";
            cin >> val;
        } // end If/Else
    } // end While loop
} // end getChoice()


void addParts(BinManager& manager) {
    // Select a bin and select an amount to add to that bin
    // Prints out how many items were added to the bin

    // initialize our variables
    int bin;
    int quant;
    
    // Prompt for Bin choice
    bin = getBinIndex();

    // Prompt for quantity
    quant = getQuantity();

    manager.addItemsToBin(bin, quant);
} // end addParts()


void removeParts(BinManager& manager) {
    // Select a bin and select an amount to remove from that bin
    // Prints out how many items were removed from the bin

    // initialize our variables
    int bin;
    int quant;

    // Prompt for Bin choice
    bin = getBinIndex();

    // Prompt for quantity
    quant = getQuantity();

    manager.removeItemFromBin(bin, quant);
} // end removeParts()


void displayBins(const BinManager& manager) {
    // prints out display report for all bins

    manager.displayReport();
} // end displayBins()


int getBinIndex() {
    // gets and validates input number for bins; returns validated number

    // initialize variables
    int input;

    // Prompt for input
    cout << "Enter a Bin number between 1 and 9:" << endl << ">> ";
    cin >> input;

    // Validate
    while (input < 1 || input > 9) {
        cout << "Choice must be between 1 and 9. Please try again:" << endl << ">> ";
        cin >> input;
    } // end While loop

    return input - 1;
} // end getBinIndex()


int getQuantity() {
    // Gets and validates quantity to be added to bin; returns validated quantity

    // initialize variable(s)
    int input;

    // Prompt for input
    cout << "Enter a quantity greater than 0:" << endl << ">> ";
    cin >> input;

    while (input < 1) {
        cout << "Choice must be 1 or greater. Please try again." << endl << ">> ";
        cin >> input;
    }

    return input;
} // end getQuantity()

