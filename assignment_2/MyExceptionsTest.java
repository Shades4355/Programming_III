// File name:   MyExceptionsTest
// Written by:  Shades Meyers
// Description: a program to test exception handling knowledge
// Challenges:  Java wouldn't compile because it (incorrectly) thought there was
//              a state where a returned variable wasn't instantiated; solved this
//              with an extra return statement (that will never be reached)
// Time Spent:  44 min + 15 min (SI)
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
                System.out.println("Input out of range (1 - 5).");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (InputMismatchException e) {
                input.nextLine(); // purge input
                System.out.println("Invalid input: please enter a number 1 - 5.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }// end try/catch
        } // end While loop

        // now that 'answer' is a valid choice, select function to execute
        MyCircle circle;
        MyRectangle rectangle;
        switch (answer) {
            case 1:
                circle = buildCircle();
                break;
            case 2:
                rectangle = buildRectangle();
                break;
            case 3:

                break;
            case 4:
                    break;
            default:
                System.out.println("Goodbye");
                input.close();
                System.exit(0); // close gracefully
        }

        input.close();
        System.exit(0); // close with 'success' status
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
                System.out.println("Please enter a decimal number.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
                input.nextLine();
            } catch (InvalidRadiusException e) {
                System.out.println("Please enter a number 0.00 or greater.");
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
                System.out.println("Please enter a decimal number");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a number greater than 0.");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
            }
        }

        return new MyRectangle(); // this return will never be hit; exists to appease Java errors
    } // end buildRectangle method

} // end program
