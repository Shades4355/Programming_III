// File name:   smA4.cpp
// Written by:  Shades Meyers
// Description: Test program for GeometricObjects classes
// Challenges:  Had trouble understanding and implementing
//                  "dynamic_cast<T>(v)"; needed to "const_cast"
//              Had trouble getting 'g' to print it's class
//                  name without the word "class" preceeding it;
//                  had to do a work around using a For loop
//              Had trouble validating input type for cin
//              Had trouble getting created shapes to delete
//
// Time Spent:   2 h 30 min + 1 h 20 min + 
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Mar-25  SM      File created
// 2024-Mar-26  SM      Added exception handling
//                      SI help with dynamic_cast
//                      SI help with validating cin input Type
// 2024-Mar-28  SM      SI help - objects aren't deleting correctly


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
    int choice, filled;
    double radius, width, height, side, side1, side2, side3;
    string color, strChoice, strRadius, strWidth, strHeight, strSide, strSide1, strSide2, strSide3, strFilled;
    GeometricObject* objectPntr = nullptr;

    while (true) {
        showMenu();
        
        // validate choice
        choice = 0;
        while (choice < 1 || choice > 5) {
            cout << "Enter your choice and press ENTER:" << endl
                 << ">> ";
            cin >> strChoice;

            try {
                choice = stoi(strChoice);
            } catch (invalid_argument) {
                choice = 0;
            }
        }
        
        // act on choice
        if (choice == 1) {
            // Circle
            radius = 0;
            while (radius == 0) {
                cout << "What's the circle's radius?" << endl << ">> ";
                cin >> strRadius;

                try {
                    radius = stod(strRadius);
                } catch (invalid_argument) {
                    radius = 0;
                }
            } // end While loop

            cout << "What's the cirlce's color?" << endl << ">> ";
            cin.ignore(1000000, '\n');
            getline(cin, color);

            filled = 2;
            while (filled != 1 && filled != 0) {
                cout << "Is the circle filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
                cin >> strFilled;

                try {
                    filled = stoi(strFilled);
                } catch (invalid_argument) {
                    filled = 2;
                }
            } // end While loop

            try {
                objectPntr = new Circle(radius, color, filled);
            } catch (Circle::InvalidRadius) {
                cout << "Invalid radius: radius must be greater than 0.0" << endl << endl;
                continue;
            }

        } else if (choice == 2) {
            // Rectangle
            width = 0;
            while (width == 0) {
                cout << "What's the rectangle's width?" << endl << ">> ";
                cin >> strWidth;

                try {
                    width = stod(strWidth);
                } catch (invalid_argument) {
                    width = 0;
                }
            } // end While loop

            height = 0;
            while (height == 0) {
                cout << "What's the rectangle's height?" << endl << ">> ";
                cin >> strHeight;

                try {
                    height = stod(strHeight);
                } catch (invalid_argument) {
                    height = 0;
                }
            } // end While loop

            cout << "What's the rectangle's color?" << endl << ">> ";
            cin.ignore(1000000, '\n');
            getline(cin, color);

            filled = 2;
            while (filled != 1 && filled != 0) {
                cout << "Is the rectangle filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
                cin >> strFilled;

                try {
                    filled = stoi(strFilled);
                } catch (invalid_argument) {
                    filled = 2;
                }
            } // end While loop

            try {
                objectPntr = new Rectangle(width, height, color, filled);
            } catch (Rectangle::InvalidSide) {
                cout << "Invalid side: sides must be greater than 0.0" << endl << endl;
                continue;
            }

        } else if (choice == 3) {
            // Square
            side = 0;
            while (side == 0) {
                cout << "What's the square's side?" << endl << ">> ";
                cin >> strSide;

                try {
                    side = stod(strSide);
                } catch (invalid_argument) {
                    side = 0;
                }
            } // end While loop

            cout << "What's the square's color?" << endl << ">> ";
            cin.ignore(1000000, '\n');
            getline(cin, color);

            filled = 2;
            while (filled != 1 && filled != 0) {
                cout << "Is the square filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
                cin >> strFilled;

                try {
                    filled = stoi(strFilled);
                } catch (invalid_argument) {
                    filled = 2;
                }
            } // end While loop

            try {
                objectPntr = new Square(side, color, filled);
            } catch (Rectangle::InvalidSide) {
                cout << "Invalid side: side must be greater than 0.0" << endl << endl;
                continue;
            }

        } else if (choice == 4) {
            // Triangle
            side1 = 0;
            while (side1 == 0) {
                cout << "What's the triangle's side1?" << endl << ">> ";
                cin >> strSide1;

                try {
                    side1 = stod(strSide1);
                } catch (invalid_argument) {
                    side1 = 0;
                }
            } // end While loop

            side2 = 0;
            while (side2 == 0) {
                cout << "What's the triangle's side2?" << endl << ">> ";
                cin >> strSide2;

                try {
                    side2 = stod(strSide2);
                } catch (invalid_argument) {
                    side2 = 0;
                }
            } // end While loop

            side3 = 0;
            while (side3 == 0) {
                cout << "What's the triangle's side3?" << endl << ">> ";
                cin >> strSide3;

                try {
                    side3 = stod(strSide3);
                } catch (invalid_argument) {
                    side3 = 0;
                }
            } // end While loop

            cout << "What's the triangle's color?" << endl << ">> ";
            cin.ignore(1000000, '\n');
            getline(cin, color);

            filled = 2;
            while (filled != 1 && filled != 0) {
                cout << "Is the triangle filled or empty? (1 = filled; 0 = empty)" << endl << ">> ";
                cin >> strFilled;

                try {
                    filled = stoi(strFilled);
                } catch (invalid_argument) {
                    filled = 2;
                }
            } // end While loop

            try {
                objectPntr = new Triangle(side1, side2, side3, color, filled);
            } catch (Triangle::InvalidSide) {
                cout << "Invalid side: sides must be greater than 0.0" << endl << endl;
                continue;
            } catch (Triangle::InvalidTriangle) {
                cout << "Invalid triangle" << endl << endl;
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
    cout << "Choose one of the shapes to build:" << endl;
    cout << "1. Circle" << endl;
    cout << "2. Rectangle" << endl;
    cout << "3. Square" << endl;
    cout << "4. Triangle" << endl;
    cout << "5. Quit the program" << endl;
} // end showMenu()

void displayGeometricObject(const GeometricObject& g) {
    cout << endl; // blank line for spacing

    string name = "";
    for (int i = 6; i < strlen(typeid(g).name()); i++) {
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

    // print Circle specific information
    GeometricObject* p = const_cast<GeometricObject*>(&g);
    Circle* c = dynamic_cast<Circle*>(p);
    if (c != nullptr) {
        cout << name << setw(15) << left << "'s radius is:"
             << setw(15) << right << c->getRadius() << endl;
        cout << name << setw(15) << left << "'s diameter is:"
             << setw(15) << right << c->getDiameter() << endl;
        // c = nullptr;
    }

    // print Rectangle specific information
    Rectangle* r = dynamic_cast<Rectangle*>(p);
    if (r != nullptr && name == "Rectangle") {
        cout << name << setw(15) << left << "'s width is:"
             << setw(15) << right << r->getWidth() << endl;
        cout << name << setw(15) << left << "'s height is:"
             << setw(15) << right << r->getHeight() << endl;
        // r = nullptr;
    }

    // print Square specific information
    Square* s = dynamic_cast<Square*>(p);
    if (s != nullptr) {
        cout << name << setw(15) << left << "'s side is:"
             << setw(15) << right << s->getSide() << endl;

        // s = nullptr;
    }

    // print Triangle specific information
    Triangle* t = dynamic_cast<Triangle*>(p);
    if (t != nullptr) {
        cout << name << setw(15) << left << "'s side1 is:"
             << setw(15) << right << t->getSide1() << endl;
        cout << name << setw(15) << left << "'s side2 is:"
             << setw(15) << right << t->getSide2() << endl;
        cout << name << setw(15) << left << "'s side3 is:"
             << setw(15) << right << t->getSide3() << endl;

        // t = nullptr;
    }

    // print object's Area and Perimeter to command line
    cout << name << setw(15) << left << "'s area: "
         << setw(15) << right << g.getArea() << endl;
    cout << name << setw(15) << left << "'s perimeter: "
         << setw(15) << right << g.getPerimeter() << endl;

    cout << endl; // add a blank line

} // end displayGeometricObject
