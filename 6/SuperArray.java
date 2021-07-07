/**
   lab skeleton
   encapsulation / SuperArray
   SuperArray is a wrapper class for an array.
   Provides "pass-thru" accessibility to array capabilities:
   - get/set by index
   - get length
   Adds functionality:
   - dynamic capacity
   - auto-grow capacity if necessary
 **/

import java.io.*;
import java.util.*;

public class SuperArray
{
  //instance vars
  private int[] data;           //where the actual data is stored
  private int numberElements;   //number of "meaningful" elements


  // ~~~~~~~~~~~~~~~ CONSTRUCTORS ~~~~~~~~~~~~~~~
  //overloaded constructor -- allows specification of initial capacity
  public SuperArray( int size ) {
     data = new int [size];
     numberElements = 0;
  }

  //default constructor -- initializes capacity to 10
  public SuperArray(){
    data = new int [10];
    numberElements = 0;
  }


  // ~~~~~~~~~~~~~~~ METHODS ~~~~~~~~~~~~~~~
  public void add( int value ) {
    // test to see if we need to grow, then grow
    if (numberElements >= data.length) {
      grow();
    }
    // SIMPLE VERSION DOES NOT AUTO-GROW CAPACITY; INSERT MORE CODE HERE LATER

    // add item
    data[numberElements] = value;

    // increment numberElements
    numberElements++;
  }//end add()

  public void add(int index, int value){
    //Do we have enough space to add one more element? If not, grow
    if(numberElements >= data.length) {
      grow();
      System.out.println("Growing by 1");
    }
    //Are we past the end of the array? If yes, grow until there is enough capacity
    //while loop to keep increasing the size until index is reached go account for indexes way out of bounds
    System.out.println("Data length: " + data.length);
    System.out.println("Number of elements " + numberElements);
    while (data.length <= index){
      grow();
      //numberElements = index;
      System.out.println("Growing again");
    }
    //are we adding in the middle of the filled-in portion of the array? If yes, shift
    System.out.println("Index " + index);

    if(index < numberElements) {
      for (int i = numberElements; i > index; i--) {
        data[i] = data[i - 1];
      }
    }
    if (numberElements < index) {
      numberElements = index;
    }
    System.out.println("Number of elements " + numberElements);
    data[index] = value;
    numberElements++;



  }

  public void remove(int index){
    for (int i = index; i < numberElements-1; i++) {
        data[i] = data[i + 1];
      }
    numberElements--;
  }

  public boolean isEmpty(){
    if (numberElements == 0) {
      return true;
    } else {
      return false;
    }
  }


  public int get(int index){
    return data[index];
  }


  public String toString() {
    String result = "";
    for (int i =0; i < numberElements; i++ ) {
      result+= data[i] + " ";
    }
    return result;
  }//end toString()


  //helper method for debugging/development phase
  public String debug(){
    String s = "";
    s = "Size: " + this.data.length;
    s = s + " LastItem: " + numberElements + "  Data: ";
    for (int i = 0; i < numberElements; i++) {
      s = s + data[i] + ", ";
    }
    s = s + "\n";
    return s;
  }//end debug()


  private void grow() {
    int[] newData = new int[data.length*2];

    for (int i = 0; i < numberElements; i++) {
      newData[i] = data[i];
    }
    data = newData;

    // create a new array with extra space

    // Q: How did you decide how much to increase capacity by?
    //A: 2x the length of data. Avoids the need to create more arrays, making it more efficient!


    // copy over all the elements from the old array to the new one

    // point data to the new array
    // Q: How does this look when illustrated using encapsulation diagram?

    //Notes on page 3 of jamboard https://jamboard.google.com/d/1CsBKH9xxzvjEut0PYOegmFkRGgguk1SWXiLlYzhq46E/edit?usp=sharing

  }//end grow()

}//end class
