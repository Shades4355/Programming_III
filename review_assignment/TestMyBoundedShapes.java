// File name:   TestMyBoundedShapes
// Written by:  Shades Meyers
// Description: main file for executing assignment. Used to create various
//          shapes and determine if their methods are functioning correctly
// Challenges:  
// Time Spent:  52 minutes + 29 minutes
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
        MyRectangle rectangle1 = new MyRectangle();
        MyRectangle rectangle2 = new MyRectangle(12, 4);
        MyRectangle rectangle3 = new MyRectangle(5.5, 2.0, "black", true);
    
        // initializing and populating an ArrayList
        ArrayList<MyBoundedShape> myBoundedShapes = new ArrayList<MyBoundedShape>();
        myBoundedShapes.add(oval1);
        myBoundedShapes.add(oval2);
        myBoundedShapes.add(oval3);
        myBoundedShapes.add(rectangle1);
        myBoundedShapes.add(rectangle2);
        myBoundedShapes.add(rectangle3);
        
        // iterate through the ArrayList and print out relevant information
        for (int i = 0; i < myBoundedShapes.size(); i++) {
            if () { // if object type is NOT MyCircle, print object

            } else { // if object type IS MyCircle, call printCircle() method

            }
        }

    }
}
