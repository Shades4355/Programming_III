// File name:   TestMyBoundedShapes
// Written by:  Shades Meyers
// Description: main file for executing assignment. Used to create various
//          shapes and determine if their methods are functioning correctly
// Challenges:  One of my biggest challenge in this file was getting the if/else comparison to work.
//          I did not remember covering this type of object comparison in Programming II,
//          so I had to do extensive Googling to find the instanceof syntax
//          An additional big challenge was figuring out how to call subclass methods when the program thought
//          they were the parent class, which lacks said methods (solution: downcasting)
// Time Spent:  4h 43m
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Jan-23  SM      Files created
// 2024-Jan-27  SM      Minor Formatting changes to print out
//                      Minor change to line 45 (from "for i..." to "for shape in myBoundedShapes")

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
        for (MyBoundedShape shape : myBoundedShapes) {
            if (shape instanceof MyRectangle) {
                MyRectangle rectangle = (MyRectangle) shape;
                System.out.println(rectangle);
                System.out.println();

                System.out.println("This is a rectangle object:");
                System.out.printf(
                    "The width is: %.1f%nThe height is: %.1f%nThe area is: %.2f%nThe perimeter is: %.2f%n", rectangle.getWidth(), rectangle.getHeight(), rectangle.getArea(), rectangle.getPerimeter()
                );
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

            } else if (shape instanceof MyCircle) {
                MyCircle circle = (MyCircle) shape;
                System.out.println(circle);
                System.out.println();

                circle.printCircle();
                System.out.println();

                System.out.println("This is a circle object:");
                System.out.println();

                System.out.printf("The radius is: %.1f%nThe diameter is: %.1f%nThe area is: %.2f%nThe perimeter is: %.2f%n", circle.getRadius(), circle.getDiameter(), circle.getArea(), circle.getPerimeter());

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } else { // if class is not MyCircle or MyRectangle, then an error has ocurred
                System.out.println("ERROR: unrecognized class: " + shape.getClass());
                System.exit(1); // exit program with error code 1
            } // end If
        } // end For loop

        for (int i = 0; i < myBoundedShapes.size(); i++) {
            System.out.printf("BoundedShape object %d is a %s%n", i + 1, myBoundedShapes.get(i).getClass().getName());
        }

        System.exit(0); // exit program successfully
    } // end Main method
} // end class
