// File name:   TestMyBoundedShapes
// Written by:  Shades Meyers
// Description: main file for executing assignment. Used to create various
//          shapes and determine if their methods are functioning correctly
// Challenges:  My biggest challenge in this file was getting the if/else comparison to work.
//          I did not remember covering this type of object comparison in Programming II,
//          so I had to do extensive Googling to find the getClass() syntax
// Time Spent:  52 minutes + 29 minutes + 
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Jan-23  SM      Files created

import java.util.ArrayList;


public class TestMyBoundedShapes {
    public static void main(String[] args) {
        
        // create subclass MyCircle objects
        MyCircle oval1 = new MyCircle();    // default constructor
        MyCircle oval2 = new MyCircle(5); // constructor with 1 argument
        MyCircle oval3 = new MyCircle(8.1, "red", false); // constructor with 3 arguments

        // create subclass MyRectangle objects
        MyRectangle rectangle1 = new MyRectangle(); // default constructor
        MyRectangle rectangle2 = new MyRectangle(12, 4); // constructor with 2 arguments
        MyRectangle rectangle3 = new MyRectangle(5.5, 2.0, "black", true); // constructor with 4 arguments
    
        // initializing and populating an ArrayList
        ArrayList<MyBoundedShape> myBoundedShapes = new ArrayList<MyBoundedShape>();
        myBoundedShapes.add(oval1);
        myBoundedShapes.add(oval2);
        myBoundedShapes.add(oval3);
        myBoundedShapes.add(rectangle1);
        myBoundedShapes.add(rectangle2);
        myBoundedShapes.add(rectangle3);
        
        // iterate through the ArrayList and print out relevant information
        MyCircle circleTester = new MyCircle();
        MyRectangle rectTester = new MyRectangle();
        for (MyBoundedShape i : myBoundedShapes) {
            if (i.getClass().equal(rectTester.getClass())) { // if object type is NOT MyCircle, print object (toString)
                System.out.println(
                    "This is a " + i.getClass() +
                    "\n" + i.toString() +
                    "\narea: " + i.getArea() +
                    "\nperimeter: " + getPerimeter()
                );
            } else if (i.getClass().equals(circleTester.getClass())) { // if object type IS MyCircle, call printCircle() method
                i.printCircle();
            } else {
                System.out.println("ERROR: incorrect class type detected:" + i.getClass());
            }
        }
    }
}
