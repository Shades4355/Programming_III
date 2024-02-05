/**
 * File name: MyShapesTest
 * Written by: outline by Prof. Yeung & final details by Shades Meyers
 * 
 * Description: a program that creates, compares, and describes various shapes.
 * Challenges:
 *
 * Time Spent:
 * 
 * Revision History:
 * Date:            By:     Action:
 * ---------------------------------------------------
 * 2024-Feb-05      SM      Downloaded MyShapesTest.java from Blackboard
 *                          Altered class names to be inline with the assignment instructions (ex: Circle -> MyCircle)
 * 
 */      

 
 import java.util.ArrayList;


public class MyShapesTest  {
  public static void main(String[] args) { 
    // Create two comparable circles
    MyCircle c1 = new MyCircle(3.5);
    MyCircle c2 = new MyCircle(10, "BLUE", true);
    // Create two comparable rectangles
    MyRectangle r1 = new MyRectangle(25,34);
    MyRectangle r2 = new MyRectangle(12,20,"YELLOW",true);
    // Create two comparable squares    
    MySquare sq1 = new MySquare(10);
    MySquare sq2 = new MySquare(24.2,"RED", true);
    // Create two comparable triangles    
    MyTriangle tr1 = new MyTriangle(2, 3, 4);
    MyTriangle tr2= new MyTriangle(10, 20.5, 30.23, "GREEN", true);
 
    
    // Writing codes here:
    //Enter codes to add the above eight objects to an ArrayList of MyBoundedShape 
    // ArrayList of MyBoundedShape objects that will be used to polymorphically store shapes
    ArrayList<MyBoundedShape> myShapes = new ArrayList<MyBoundedShape>();
    myShapes.add(c1);
    myShapes.add(c2);

    myShapes.add(r1);
    myShapes.add(r2);

    myShapes.add(sq1);
    myShapes.add(sq2);

    myShapes.add(tr1);
    myShapes.add(tr2);

    // Utilize a loop by invoking the necessary methods to print the following message for each object:
    // The object's name, String description of Objects, its area and perimeter with two decimal places, 
    //and how to draw this object
    int objCount = 0;
    for (MyBoundedShape shape: myShapes) {
        objCount += 1;
        System.out.println("The object%d is: %s".formatted(objCount, shape.getName()));
        System.out.println(shape);

        System.out.println(""); // print a blank line

        System.out.println("Area is %.2f".formatted(shape.getArea()));
        System.out.println("Perimeter is %.2f".formatted(shape.getPerimeter()));
        System.out.println("How to draw this object: %s".formatted(shape.howToDraw()));

        /*
        * For example:
        * The object1 is: Circle
        * created on Sun Sep 10 15:10:09 EDT 2023
        * color: white and filled: false
        * radius: 3.5
        * 
        * Area is 38.48
        * Perimeter is 21.99
        * How to draw this object: Color with the radius
        * ------------------------------------
        *
        * The object2 is: Circle
        * created on Sat Feb 03 00:32:44 EST 2024
        * color: BLUE and filled: true
        * radius: 10.0
        * 
        * Area is 314.16
        * Perimeter is 62.83
        * How to draw this object: Color with the radius
        * ------------------------------------
        *
        * The object3 ....
        */

        System.out.println("------------------------------------\n"); // Use it to divide each object
    }

    
    
    //comparison of two objects with the same shapes
    System.out.println("\nComparison of two objects with the same shapes: \n"); 

    System.out.println("Comparing two circle objects: ");
    //using equals, compareTo and max methods to compare two circle objects
    /* For example:
    Comparing two circle objects: 
    object1 equals to object2: false
    object1 compares to object2: -1
    The max geometric circle object is created on Sun Sep 10 15:10:09 EDT 2023
    color: BLUE and filled: true
    radius: 10.0
    */
    //writing codes here   
    System.out.println("object1 equals object2: %b".formatted(c1.equals(c2)));
    System.out.println("object1 compares to object2: %d".formatted(c1.compareTo(c2)));
    System.out.println("The max geometric circle object is %s".formatted(MyBoundedShape.max(c1, c2)));

    System.out.println("------------------------------------\n"); //Use it to divide each object
        
    System.out.println("Comparing two rectangle objects: ");
    //using equals, compareTo and max methods to compare two rectangle objects
    /* For example:
    Comparing two rectangle objects: 
    object3 equals to object4: false
    object3 compares to object4: 1
    The max geometric rectangle object is created on Sat Feb 03 00:25:13 EST 2024
    color: white and filled: false
    width: 25.0 and height: 34.0
    ------------------------------------
    */
    //writing codes here
    System.out.println("object3 equals object4: %b".formatted(r1.equals(r2)));
    System.out.println("object3 compares to object4: %d".formatted(r1.compareTo(r2)));
    System.out.println("The max geometric circle object is %s".formatted(MyBoundedShape.max(r1, r2)));

    System.out.println("------------------------------------\n"); //Use it to divide each object

    System.out.println("Comparing two square objects: ");
    //using equals, compareTo and max methods to compare two square objects  
    /* For example:
    Comparing two square objects: 
    object5 equals to object6: false
    object5 compares to object6: -1
    The max geometric square object is created on Sat Feb 03 00:25:13 EST 2024
    color: RED and filled: true
    side: 24.2
    ------------------------------------
    */
    System.out.println("object5 equals to object6: %b".formatted(sq1.equals(sq2)));
    System.out.println("object5 compares to object6: %d".formatted(sq1.compareTo(sq2)));
    System.out.println("The max geometric square object is %s".formatted(MyBoundedShape.max(sq1, sq2)));

    System.out.println("------------------------------------\n"); //Use it to divide each object
        
    System.out.println("Comparing two triangle objects: ");
    //using equals, compareTo and max methods to compare two triangle objects   
    /*
    For example: 
    Comparing two triangle objects: 
    object8 equals to object8: true
    object8 compares to object7: 1
    The max geometric square object is created on Sat Feb 03 00:25:13 EST 2024
    color: GREEN and filled: true
    side1 = 10.0
    side2 = 20.5
    side3 = 30.2
    */
    //writing codes here
    System.out.println("object8 equals to object8: %b".formatted(tr2.equals(tr2)));
    System.out.println("object8 compares to object7: %d".formatted(tr2.compareTo(tr1)));
    System.out.println("The max geometric square object is $s".formatted(MyBoundedShape.max(tr1, tr2)));

    System.out.println("------------------------------------\n");//Use it to divide each object
        
    }//end main method
}//end class
