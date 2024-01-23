// File name:   TestMyBoundedShapes
// Written by:  Shades Meyers
// Description: main file for executing assignment. Used to create various
//          shapes and determine if their methods are functioning correctly
// Challenges:  My biggest challenge in this file was getting the if/else comparison to work.
//          I did not remember covering this type of object comparison in Programming II,
//          so I had to do extensive Googling to find the getClass() syntax
//          An additional challenge was figuring out how to call subclass methods when the program thought
//          they were the parent class, which lacks said methods
// Time Spent:  52 minutes + 29 minutes + 2h 25m + 
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
        for (int i = 0; i < myBoundedShapes.size(); i++) {
            if (myBoundedShapes.get(i) instanceof MyRectangle) {
                MyRectangle rectangle = (MyRectangle) myBoundedShapes.get(i);
                System.out.printf(
                    "This is a %s\n%s\n\nwidth: %d.1f\nheight: %d.1f\narea: %d.2f\nperimeter: %d.2f", rectangle.getClass(),  rectangle.toString(), rectangle.getWidth(), rectangle.getHeight(), rectangle.getArea(), rectangle.getPerimeter()
                );
            } else if (myBoundedShapes.get(i) instanceof MyCircle) {
                MyCircle circle = (MyCircle) myBoundedShapes.get(i);
                circle.printCircle();
                System.out.println();
            } else { // if class is not MyCircle or MyRectangle, then an error has ocurred
                System.out.println("ERROR: unrecognized class: " + myBoundedShapes.get(i).getClass());
                System.exit(1); // exit program with error code 1
            } // end If
        } // end For loop

        // for (MyBoundedShape i : myBoundedShapes) {
            // if (i.getClass().equal(rectTester.getClass())) { // if object type is NOT MyCircle, print object (toString)
            //     System.out.println(
            //         "This is a " + i.getClass() +
            //         "\n" + i.toString() +
            //         "\narea: " + i.getArea() +
            //         "\nperimeter: " + getPerimeter()
            //     );
            // } else if (i.getClass().equals(circleTester.getClass())) { // if object type IS MyCircle, call printCircle() method
            //     i.printCircle();
            //     System.out.println(
            //         "\nradius: " + i.getRadius() +
            //         "\ndiameter: " + i.getDiameter() +
            //         "\narea: " + i.getArea() +
            //         "\nperimeter: " + i.getPerimeter()
            //         );
            // } else {
            //     System.out.println("ERROR: incorrect class type detected:" + i.getClass());
            // }
        // } // end For loop

        System.exit(0); // exit program successfully
    } // end Main method
} // end class
