//6/SuperArrayDriver
//Collaborators: lfridman2016	mlaks23	jkimbxv

import java.io.*;
import java.util.*;

public class SuperArrayDriver {
  public static void main( String[] args ){


    System.out.println("Testing default constructor.");
    SuperArray sa = new SuperArray();
    System.out.println("Testing empty print:");
    System.out.println(sa);
    System.out.println("Testing isEmpty (should be true)");
    System.out.println(sa.isEmpty());

    // -----------------------------------------------------------
    // YOUR HOMEGROWN/HOUSEMADE/ROLL-YOUR-OWN TEST METHODS HERE...

    // -----------------------------------------------------------
    //precondition: newly-instantiated SuperArray of default capacity
    System.out.println("Testing overfill (calling grow() in add)");
    for (int i=0; i<10; i++) {
      sa.add(i);
    }//for i
    System.out.println(sa);
    System.out.println(sa.isEmpty());


   System.out.println("\nTesting add at different indices (end)");
   //sa.add(5, 10);
    //System.out.println(sa);
    sa.add(50, 100);
    sa.add(51, 101);
    System.out.println(sa);
    //sa.add(20, 100);
    //System.out.println(sa);


    System.out.println("\nTesting remove at 0, 5, and 15 (end)");
    //sa.remove(0);
    //System.out.println(sa);
    sa.remove(5);
    System.out.println(sa);
    //sa.remove(15);
    //System.out.println(sa);


  }//main

}//class SuperArrayDriver
