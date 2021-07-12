import java.io.*;
import java.util.*;

/*

Setup:
 1.Make a folder under your work repo named: ds
 2. Make another folder under that named sort1
 3. Copy this file and SortDemoDriver.java into the ds/sort1 folder

Lab:

Part 1:
  1. Analyze the two constructors - try to figure out how they work.
  2. Compile and run the program (SortDemoDriver.java and SortDemo.java) and confirm
   the behavior of the constructors.

Part 2:
  1. Read the description of findSmallestIndex and complete the method.
  2. Uncomment the lines in SortDemoDriver to test.

Part 3:
  1. Complete the sort method - read comments for description
  2. Uncomment the lines in sortDemoDriver to test.

*/

public class SortDemo{

    /* Instance Variables */
    private ArrayList<Integer> data;  // to store the data
    private Random r;

  // can you include non-instance variables in a constructor?
  // can you make a constructor and omit certain instance variables?
  // When to use or not use this. ?

    //constructs ArrayList data length 15 filled with random numbers [0,19]
    public SortDemo(){
	    data = new ArrayList<Integer>(); // create new ArrayList of integers
	    r = new Random();  // create variable to hold random number
	    for (int i=0;i<15;i++){ // loop 15 times
	    data.add(r.nextInt(20)); // assign a random integer into ArrayList btwn 0 and 19
    }//for
  }//SortDemo

    //constructs ArrayList data with specified length size filled with random numbers [0,19]
    public SortDemo(int size){ // creates parameterized constructor - argument for size of ArrayList
	     data = new ArrayList<Integer>(); // create new ArrayList of integers
	     r = new Random(); // create variable to hold random number
	     for (int i=0;i<size;i++){//loop size times (= to argument passed through parameter)
	        data.add(r.nextInt(20)); // assign a random integer into ArrayList btwn 0 and 19
	     }
    }//end constructor with parameter

    /*
      return the index of the ArrayList data from index start to the end
      Example, if the arraylist has:
      5,3,10,6,8
      if start was 2 (start at index 2, value 10) then it woudl return 3 which is the index of the value
      6 which is the index with the smallest value from start to end

    */
    //finds the index of the minimum value for the sub-ArrayList from var start to end
    public int findSmallestIndex(int start){
	     int smallIndex = start; // set smallIndex to start argument value
       int smallestValue=this.data.get(start); // set smallestValue to ArrayList value at start index

       for (int i= start + 1;i<this.data.size();i++){ // loop starting at start value + 1 going to length of ArrayList
         if (this.data.get(i) < smallestValue){ // if value in ArrayList at i index is less than current smallestValue...
           smallestValue = this.data.get(i); //...set the smallest value to the value at index i
           smallIndex = i; // set the smallest index to i
         }
       }

	// start a variable at the one after start
	// your code here

	// loop from that variable to end and update smallIndex as needed
	// your code here
	     return smallIndex;  // return the index of the smallest value
    } //end findSmallestIndex

    public int get(int index){
      return data.get(index);
    }

    public void sort(){
	     int i; // declare variable for loop
	     for (i=0;i < data.size()-1; i++){ // for loop to iterate through data
         int currMinIndex = findSmallestIndex(i); // initializing variable to store current Minimum index
         if (data.get(currMinIndex)<data.get(i)){
           swap(i,currMinIndex);
         }
	     }
    }

    public void swap(int indexA, int indexB) {
      int temp = data.get(indexA);
      data.set(indexA,data.get(indexB));
      data.set(indexB,temp);
    }

    /* If you finish the lab early you can get started on this */
    public int linearSearch(int value){
	     // loop through the ArrayList data
      for (int i = 0; i<data.size(); i++){
        if (data.get(i) == value){
          return value;
        }
      }
	    return -1; // replace this return
    }

    //binary search works only with sorted array
    /* If you finish the lab early you can get started on this */
    public int binarySearch(int value){
	     int lowerIndex = 0;
	     int upperIndex = data.size();
	     int middleIndex = data.size()/2;

	     while (middleIndex > lowerIndex && middleIndex < upperIndex){
         int currMid = data.get(middleIndex);
         if (currMid > value){
           upperIndex = middleIndex;
           middleIndex = (int)((lowerIndex + upperIndex)/2);
         }else if (currMid < value){
           lowerIndex = middleIndex;
           middleIndex = (int)((lowerIndex + upperIndex)/2);
         }else{
           return middleIndex;
         }
	      }
	     return -1; // replace this return
    }

  public String toString(){
	   return ""+data;
  }
}
