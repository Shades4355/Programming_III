// File name:   smA4.cpp
// Written by:  Shades Meyers
// Description: Test program for GeometricObjects classes
// Challenges:  Had trouble understanding and implementing
//                  "dynamic_cast<T>(v)"
//              Had trouble getting 'g' to print it's class
//                  name without the word "class" preceeding it;
//                  had to do a work around using a For loop
//
// Time Spent:   2 h 30 min + 7 min + 
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Added exception handling
//                      Added input validation to prompts
//                      SI help with dynamic_cast


#include "Circle.h"
#include "Rectangle.h"
#include "Triangle.h"
#include "Square.h"
#include <iostream>
#include <iomanip>
using namespace std;


// function declarations
void showMenu();
void displayGeometricObject(const GeometricObject& g);


int main() {
    // variable declaration
    int choice;
    double radius, width, height, side, side1, side2, side3 = NULL;
    string color;
    bool filled = NULL;
    GeometricObject* objectPntr = nullptr;

    while (true) {
        showMenu();
        
        // validate choice
        choice = 0; 
        while (choice < 1 || choice > 5) {
            cout << "Enter your choice and press ENTER:" << endl
                 << ">> ";
            cin >> choice;
        }
        
        // act on choice
        if (choice == 1) {
            // Circle
            cout << "What's the circle's radius?" << endl << ">> ";
            cin >> radius;

            while (typeid(radius).name() != typeid(double()).name()) {
                cin.clear(); // not working?
                cout << "What's the circle's radius?" << endl << ">> ";
                cin >> radius;
            }

            cout << "What's the cirlce's color?" << endl << ">> ";
            cin >> color;

            cout << "Is the circle filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
            cin >> filled;

            try {
                objectPntr = new Circle(radius, color, filled);
            } catch (Circle::InvalidRadius) {
                cout << "Invalid radius: radius must be greater than 0.0" << endl << endl;
                continue;
            }

        } else if (choice == 2) {
            // Rectangle
            cout << "What's the rectangle's width?" << endl << ">> ";
            cin >> width;

            cout << "What's the rectangle's height?" << endl << ">> ";
            cin >> height;

            cout << "What's the rectangle's color?" << endl << ">> ";
            cin >> color;

            cout << "Is the rectangle filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
            cin >> filled;

            try {
                objectPntr = new Rectangle(width, height, color, filled);
            } catch (Rectangle::InvalidSide) {
                cout << "Invalid side: sides must be greater than 0.0" << endl << endl;
                continue;
            }

        } else if (choice == 3) {
            // Square
            cout << "What's the square's side?" << endl << ">> ";
            cin >> side;

            cout << "What's the square's color?" << endl << ">> ";
            cin >> color;

            cout << "Is the square filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
            cin >> filled;
            try {
                objectPntr = new Square(side, color, filled);
            } catch (Rectangle::InvalidSide) {
                cout << "Invalid side: side must be greater than 0.0" << endl << endl;
                continue;
            }

        } else if (choice == 4) {
            // Triangle
            cout << "What's the triangle's side1?" << endl << ">> ";
            cin >> side1;

            cout << "What's the triangle's side2?" << endl << ">> ";
            cin >> side2;

            cout << "What's the triangle's side3?" << endl << ">> ";
            cin >> side3;

            cout << "What's the triangle's color?" << endl << ">> ";
            cin >> color;

            cout << "Is the triangle filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
            cin >> filled;

            try {
                objectPntr = new Triangle(side1, side2, side3, color, filled);
            } catch (Triangle::InvalidSide) {
                cout << "Invalid side: sides must be greater than 0.0" << endl << endl;
                continue;
            }

        } else {
            // quit program
            cout << "Goodbye" << endl;
            delete objectPntr;
            objectPntr = nullptr;

            return 0; // end program successfully
        } // end If/Else block

        // Print out relevent values
        displayGeometricObject(*objectPntr);

        // clear objectPntr for next loop
        delete objectPntr;
        objectPntr = nullptr;
    } // end while
} // end main


// function initializations
void showMenu() {
    cout << "1. Circle" << endl;
    cout << "2. Rectangle" << endl;
    cout << "3. Square" << endl;
    cout << "4. Triangle" << endl;
    cout << "5. Quit the program" << endl;
} // end showMenu()

void displayGeometricObject(const GeometricObject& g) {

    string name = "";
    for (int i = 5; i < strlen(typeid(g).name()); i++) {
        name += typeid(g).name()[i];
    }

    // print object's Color to command line
    cout << name << setw(15) << left << "'s color: "
        << setw(15) << right << g.getColor() << endl;

    // print "filled" or "not filled" to command line
    if (g.isFilled()) {
        cout << name << setw(15) << left << "'s filling: "
            << setw(15) << right << "filled" << endl;
    } else {
        cout << name << setw(15) << left << "'s filling: "
            << setw(15) << right << "not filled" << endl;
    }

    /*
    // print Circle specific information
    GeometricObject* p = &g; // not working...
    Circle* c = dynamic_cast<Circle*>(p);
    if (c != nullptr) {
        cout << setw(15) << left << name << "'s radius is:"
             << setw(15) << right << c->getRadius() << endl;
    }
    delete c;
    */

    // print object's Area and Perimeter to command line
    cout << name << setw(15) << left << "'s area: "
        << setw(15) << right << g.getArea() << endl;
    cout << name << setw(15) << left << "'s perimeter: "
        << setw(15) << right << g.getPerimeter() << endl;

    cout << endl; // add a blank line

} // end displayGeometricObject
