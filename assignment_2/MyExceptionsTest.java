// File name:   MyExceptionsTest
// Written by:  Shades Meyers
// Description: a program to test exception handling knowledge
// Challenges:  Java wouldn't compile because it (incorrectly) thought there was
//              a state where a returned variable wasn't instantiated; solved this
//              by replacing "looping" (which was set to true) with "true" in while loops.
// Challenge 2: Scanner always gives me trouble when put in a loop;
//              solution was to pass "input" to methods instead of trying to manage 
//              Scanner's state.
// Time Spent:  3 hours, 13 min
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      File created
//                      Attended SI meeting for help with buildCircle() method (see "challenges" above)
//                      Finished after class
//                      Refactored so whole program runs until 'quit' option is selected (see Challenge 2)
// 2024-Feb-26  SM      Fixed typo
// 2024-Feb-28  SM      Refactored code - moved error messages to their shapes
//                      Switched decimal printouts from .00 to .0
//                      Added an IllegalArgumentException catch to buildTriangle() for if a side is negative


import java.util.InputMismatchException;
import java.util.Scanner;


public class MyExceptionsTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int answer;

        while (true) {
            answer = 0;

            while (answer < 1) {
                System.out.println("\n1. Circle");
                System.out.println("2. Rectangle");
                System.out.println("3. Square");
                System.out.println("4. Triangle");
                System.out.println("5. Quit");
                System.out.println();

                System.out.print("Enter your choice (as a number):\n>> ");
                try {
                    answer = input.nextInt();

                    if (answer < 1 || answer > 5) {
                        throw new IllegalArgumentException("Input out of range (1 - 5).");
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println(e);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                } catch (InputMismatchException e) {
                    input.nextLine(); // purge input
                    System.err.println(e + ": Invalid input: please enter a number 1 - 5.");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                }// end try/catch
            } // end While loop

            // now that 'answer' is a valid choice, select which function to execute
            switch (answer) {
                case 1:
                    MyCircle circle = buildCircle(input);
                    System.out.println(circle);
                    System.out.printf("Perimeter: %.1f%n", circle.getPerimeter());
                    System.out.printf("Area: %.1f%n", circle.getArea());
                    break;
                case 2:
                    MyRectangle rectangle = buildRectangle(input);
                    System.out.println(rectangle);
                    System.out.printf("Perimeter: %.1f%n", rectangle.getPerimeter());
                    System.out.printf("Area: %.1f%n", rectangle.getArea());
                    break;
                case 3:
                    MySquare square = buildSquare(input);
                    System.out.println(square);
                    System.out.printf("Perimeter: %.1f%n", square.getPerimeter());
                    System.out.printf("Area: %.1f%n", square.getArea());
                    break;
                case 4:
                    MyTriangle triangle = buildTriangle(input);
                    System.out.println(triangle);
                    System.out.printf("Perimeter: %.1f%n", triangle.getPerimeter());
                    System.out.printf("Area: %.1f%n", triangle.getArea());
                    break;
                case 5:
                    System.out.println(); // blank line
                    System.out.println("Goodbye");
                    input.close(); // close input
                    System.exit(0); // exit program with a 'successful' status
            } // end Switch statements
        } // end while loop
    } // end Main

    
    // shape functions
    public static MyCircle buildCircle(Scanner input) {
        while (true) {
            System.out.print("Please enter a radius of 0 or greater:\n>> ");
            try {
                Double radius = input.nextDouble();
                MyCircle circle = new MyCircle(radius);

                return circle;
            } catch (InputMismatchException e) {
                System.err.println(e + ": Enter a decimal number.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                input.nextLine(); // purge junk input
            } catch (InvalidRadiusException e) {
                System.err.println(e);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } // end Try/Catch
        } // end While loop
    } // end buildCircle method

    public static MyRectangle buildRectangle(Scanner input) {       
        while (true) {
            try {
                System.out.print("Please enter a width:\n>> ");
                double width = input.nextDouble();

                System.out.print("\n Please enter a height:\n>> ");
                double height = input.nextDouble();

                MyRectangle rectangle = new MyRectangle(width, height);

                return rectangle;
            } catch (InputMismatchException e) {
                input.nextLine(); // purge junk input
                System.err.println(e + ": Enter a decimal number");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (IllegalArgumentException e) {
                System.err.println(e);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } // end try/catch
        } // end While loop
    } // end buildRectangle method

    public static MySquare buildSquare(Scanner input) {
        while (true) {
            System.out.print("Please enter a side greater than 0.00:\n>> ");
            try {
                double side = input.nextDouble();
                MySquare square = new MySquare(side);

                return square;
            } catch (InputMismatchException e) {
                System.err.println(e + ": Enter a decimal number.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                input.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } // end try/catch
        } // end While loop
    } // end buildSquare() method

    public static MyTriangle buildTriangle(Scanner input) {
        while (true) {
            try {
                System.out.print("Please enter a side:\n>> ");
                double side1 = input.nextDouble();

                System.out.print("\nPlease enter a second side:\n>> ");
                double side2 = input.nextDouble();

                System.out.print("\nPlease enter a third side:\n>> ");
                double side3 = input.nextDouble();

                MyTriangle triangle = new MyTriangle(side1, side2, side3);

                return triangle;
            } catch (InputMismatchException e) {
                input.nextLine(); // purge junk input
                System.err.println(e + ": Enter a decimal number");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (IllegalTriangleException e) {
                System.err.println(e);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (IllegalArgumentException e) {
                System.err.println(e);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }// end try/catch
        } // end While loop
    }// end buildTriangle() method

} // end program
