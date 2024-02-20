// File name:   MyExceptionsTest
// Written by:  Shades Meyers
// Description: a program to test exception handling knowledge
// Challenges:  Java wouldn't compile because it (incorrectly) thought there was
//              a state where a returned variable wasn't instantiated; solved this
//              with an extra return statement (that will never be reached)
// Time Spent:  75 min + 15 min (SI) + 10 minutes (class)
//
// Revision history:
// Date:        By:     Action:
// -------------------------------
// 2024-Feb-20  SM      File created
//                      Attended SI meeting for help with buildCircle() method (see "challenges" above)


import java.util.InputMismatchException;
import java.util.Scanner;


public class MyExceptionsTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int answer = 0;

        while (answer < 1) {
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Square");
            System.out.println("4. Triangle");
            System.out.println("5. Quit");
            System.out.println();

            System.out.print("Enter your choice (as a number):\n>> ");
            try {
                answer = input.nextInt();

                if (answer < 1 || answer > 5) {
                    throw new IllegalArgumentException("Input out of range.");
                }
            } catch (IllegalArgumentException e) {
                answer = 0;
                System.err.println(e + ": Input out of range (1 - 5).");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (InputMismatchException e) {
                input.nextLine(); // purge input
                System.err.println(e + ": Invalid input: please enter a number 1 - 5.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }// end try/catch
        } // end While loop

        // now that 'answer' is a valid choice, select function to execute
        switch (answer) {
            case 1:
                MyCircle circle = buildCircle();
                System.out.println(circle);
                System.out.printf("Perimeter: %.2f%n", circle.getPerimeter());
                System.out.printf("Area: %.2f%n", circle.getArea());
                break;
            case 2:
                MyRectangle rectangle = buildRectangle();
                System.out.println(rectangle);
                System.out.printf("Perimeter: %.2f%n", rectangle.getPerimeter());
                System.out.printf("Area: %.2f%n", rectangle.getArea());
                break;
            case 3:
                MySquare square = buildSquare();
                System.out.println(square);
                System.out.printf("Perimeter: %.2f%n", square.getPerimeter());
                System.out.printf("Area: %.2f%n", square.getArea());
                break;
            case 4:
                MyTriangle triangle = buildTriangle();
                System.out.println(triangle);
                System.out.printf("Perimeter: %.2f%n", triangle.getPerimeter());
                System.out.printf("Area: %.2f%n", triangle.getArea());
                break;
        } // end Switch statements

        System.out.println(); // blank line
        System.out.println("Goodbye");

        input.close();
        System.exit(0); // close successfully (status: 0)
    } // end Main

    // shape functions
    public static MyCircle buildCircle() {
        // variable declarations
        Scanner input = new Scanner (System.in);
        boolean looping = true;

        while (looping) {
            System.out.println("please enter a radius of 0 or greater.");
            try {
                double radius = input.nextDouble();
                MyCircle circle = new MyCircle(radius);
                input.close();

                return circle;
            } catch (InputMismatchException e) {
                System.err.println(e + ": Please enter a decimal number.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                input.nextLine();
            } catch (InvalidRadiusException e) {
                System.err.println(e);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
        } // end While loop

        return new MyCircle(); // this return will never be hit; exists to appease Java errors
    } // end buildCircle method

    public static MyRectangle buildRectangle() {
        // variable declarations
        Scanner input = new Scanner (System.in);
        boolean looping = true;
        
        while (looping) {
            try {
                System.out.print("Please enter a width:\n>> ");
                double width = input.nextDouble();

                System.out.print("\n Please enter a height:\n>> ");
                double height = input.nextDouble();

                MyRectangle rectangle = new MyRectangle(width, height);

                input.close();
                return rectangle;
            } catch (InputMismatchException e) {
                input.nextLine(); // purge junk input
                System.err.println(e + ": enter a decimal number");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (IllegalArgumentException e) {
                System.err.println(e + ": height and width must be > 0.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
        }

        return new MyRectangle(); // this return will never be hit; exists to appease Java errors
    } // end buildRectangle method

    public static MySquare buildSquare() {
        // variable declarations
        Scanner input = new Scanner(System.in);
        boolean looping = true;

        while (looping) {
            System.out.println("please enter a side of 0.00 or greater.");
            try {
                double side = input.nextDouble();
                MySquare square = new MySquare(side);
                input.close();

                return square;
            } catch (InputMismatchException e) {
                System.err.println(e + ": Please enter a decimal number.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                input.nextLine();
            } catch (IllegalArgumentException e) {
                System.err.println(e + ": Please enter a number 0.00 or greater.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
        } // end While loop

        return new MySquare(); // this return will never be hit; exists to appease Java errors

    } // end buildSquare() method

    public static MyTriangle buildTriangle() {
        // variable declarations
        Scanner input = new Scanner(System.in);
        boolean looping = true;

        while (looping) {
            try {
                System.out.print("Please enter a side:\n>> ");
                double side1 = input.nextDouble();

                System.out.print("\nPlease enter a second side:\n>> ");
                double side2 = input.nextDouble();

                System.out.print("\nPlease enter a third side:\n>> ");
                double side3 = input.nextDouble();

                MyTriangle rectangle = new MyTriangle(side1, side2, side3);

                input.close();
                return rectangle;
            } catch (InputMismatchException e) {
                input.nextLine(); // purge junk input
                System.err.println(e + ": Please enter a decimal number");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (IllegalTriangleException e) {
                System.err.println(e);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
        }

        return new MyTriangle(); // this return will never be hit; exists to appease Java errors
    }// end buildTriangle() method

} // end program
