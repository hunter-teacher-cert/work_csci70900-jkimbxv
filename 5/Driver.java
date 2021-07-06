//Jiyoon Kim and Tiffany Wong

import java.io.*;
import java.util.*;

public class Driver {

  public static void main(String[] args) {

    //declare a var of appropriate type to assign an instance of Time to
    Time t; //instance of Time class

    //assign var the address of a newly-apportioned Time object
    t = new Time();

    //assign a Time var the value null **
    Time newT = null;

    //assign a Time var the value of an existing Time var ** driver only
    newT = t;

    //print all of the above (See multiple ways to do this? Try all -- and document in comments!) **
    t.printTime();

    //test for equality of each of the Time instances above. Print results. **
    t = new Time(10,50,59.0);
    Time t2 = new Time(1,13,2.0);
    System.out.println(t2.equals(t));

    //Time t = new Time();
    Time t0 = new Time(11, 59, 59.9);
    Time t1 = new Time(11, 59, 59.9);
    //Time t2 = null;
    System.out.println(t0);
    System.out.println(t1);
    System.out.println(t2);
    System.out.println( t0 == t1);
    System.out.println( t0 == t2);
    System.out.println(t0.equals(t1));

    /*
    test .equals without defining it in Time.java
    */

    //add two Time objects and print results
    //t.add(t2).printTime();

    //add two Time objects and save the result in another Time object
    Time t3 = new Time();
    t3 = t.add(t2);
    t3.printTime();


  }//end main()

}//end class
