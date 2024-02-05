//import any necessaary package here

//For MyShapesTest code documentation
/**
 * File name: MyShapesTest
 * Written by: outline by Prof. Yeung & final touches by Shades Meyers
 * 
 * Description:
 * Challenges:
 *
 * Time Spent:
 * 
 * Revision History:
 * Date: By: Action:
 * ---------------------------------------------------
 * 2024-Feb-05 SM Downloaded MyShapesTest.java from Blackboard
 * 
 */      


public class MyShapesTest  {
    
  public static void main(String[] args) { 

    // Create two comparable circles
    Circle c1 = new Circle(3.5);
    Circle c2 = new Circle(10, "BLUE", true);
    // Create two comparable rectangles
    Rectangle r1 = new Rectangle(25,34);
    Rectangle r2 = new Rectangle(12,20,"YELLOW",true);
    // Create two comparable squares    
    Square sq1 = new Square(10);
    Square sq2 = new Square(24.2,"RED", true);
    // Create two comparable triangles    
    Triangle tr1 = new Triangle(2, 3, 4);
    Triangle tr2= new Triangle(10, 20.5, 30.23, "GREEN", true);
 
    
    // Writing codes here:
    //Enter codes to add the above eight objects to an ArrayList of MyBoundedShape 
    // ArrayList of MyBoundedShape objects that will be used to polymorphically store shapes

    // Utilize a loop by invoking the necessary methods to print the following message for each object:
    // The object's name, String description of Objects, its area and perimeter with two decimal places, 
    //and how to draw this object

    /* For example:
    The object1 is: Circle
    created on Sun Sep 10 15:10:09 EDT 2023
    color: white and filled: false
    radius: 3.5

    Area is 38.48
    Perimeter is 21.99
    How to draw this object: Color with the radius
    ------------------------------------
    The object2 is: Circle
    created on Sat Feb 03 00:32:44 EST 2024
    color: BLUE and filled: true
    radius: 10.0

    Area is 314.16
    Periemeter is 62.83
    How to draw this object: Color with the radius
    ------------------------------------
    The object3 ....
    */
            
    System.out.println("------------------------------------\n"); //Use it to divide each object
    
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
        System.out.println("------------------------------------\n");//Use it to divide each object
        
    }//end main method
}//end class
