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


    public SortDemo(){
	     data = new ArrayList<Integer>();
	     r = new Random();
	     for (int i=0;i<15;i++){
	       data.add(r.nextInt(20));
	     }
    }

    public SortDemo(int size){
	     data = new ArrayList<Integer>();
	      r = new Random();
	       for (int i=0;i<size;i++){
	          data.add(r.nextInt(20));
	       }
    }

    public int get(int index){
	     return this.data.get(index);
    }

    /*
      return the index of the ArrayList data from index start to the end
      Example, if the arraylist has:
      5,3,10,6,8
      if start was 2 (start at index 2, value 10) then it woudl return 3 which is the index of the value
      6 which is the index with the smallest value from start to end
    */
    public int findSmallestIndex(int start){
    // start a variable at the one after start
	     int smallIndex = start;

	  // loop from that variable to end and update smallIndex as needed
	  for (int i = smallIndex + 1; i < this.data.size(); i++){
      if (this.data.get(i) < this.data.get(smallIndex)){
		      smallIndex = i;
	    }
	   }
	    return smallIndex;
    }


    public void sort(){
	     int i;
	     int smallIndex;
	     int tmp;
	     for (i=0;i < data.size()-1; i++){
	        smallIndex = findSmallestIndex(i);
	        tmp = data.get(smallIndex);
	        data.set(smallIndex,data.get(i));
	        data.set(i,tmp);
        }
    }

  /* If you finish the lab early you can get started on this */
  public int linearSearch(int value){
      return 0; // replace this return
	}

	/* If you finish the lab early you can get started on this */
	public int binarySearch(int value){
	    return 0;
	}

  public String toString(){
	   return ""+data;
  }
    /*------------------------- MERGESORT STUFF -----------------*/
    // Preconditions: a and b are ArrayLists of Integers and
    //                both are in increasing order
    // Return: a new ArrayList of Integers that is the result
    //         of merging a and b. The new ArrayList
    //         should be in increasing order
    private ArrayList<Integer> mergeSort (ArrayList<Integer> a){
      if (a.size() <= 1) { //base case
        return a;
      } //end base case

      int lo = 0;
      int hi = a.size();
      int mid = (lo + hi)/2;

      //get left part of ArrayList
      ArrayList<Integer> left = new ArrayList<Integer>();
      for(int i = 0; i < mid; i++){
        left.add(a.get(i));
      }

      //get right part of ArrayList
      ArrayList<Integer> right = new ArrayList<Integer>();
      for (int i = mid; i < hi; i++){
        right.add(a.get(i));
      }

      ArrayList<Integer> leftSorted = mergeSort(left);
      ArrayList<Integer> rightSorted = mergeSort(right);

      return merge(leftSorted,rightSorted);

    } //end mergeSort

    private ArrayList<Integer> merge(ArrayList<Integer> a,ArrayList<Integer> b){
      ArrayList<Integer> merged = new ArrayList<Integer>();
      int counterA = 0; //pointer var for ArrayList a
      int counterB = 0; //pointer var for ArrayList b
      while (merged.size() != (a.size() + b.size())) {
         if (counterA == a.size()){ //reached end of A so just append stuff from B
           merged.add(b.get(counterB));
           counterB++;
         }else if (counterB == b.size()){ //reached end of B so just append stuff from A
           merged.add(a.get(counterA));
           counterA++;
         }else if ((a.get(counterA)<= b.get(counterB))){ //if number in a is less than number in b
          merged.add(a.get(counterA)); //adding from a
          counterA++;
        }else{
          merged.add(b.get(counterB)); //else, adding from b
          counterB++;
        }
      } //end while loop
      return merged;
    }//end merge


    private ArrayList<Integer> fillForMerge(int size){
      ArrayList<Integer> a = new ArrayList<Integer>();
      int lastVal = r.nextInt(10);
      for (int i = 0 ; i < size ; i=i+1){
        a.add(lastVal);
        lastVal = lastVal + r.nextInt(10);
      }
      return a;

    } //end fillForMerge
    private ArrayList<Integer> fillForMergeSort(int size){
      ArrayList<Integer> a = new ArrayList<Integer>();
      int lastVal = r.nextInt(10);
      for (int i = 0 ; i < size ; i=i+1){
        a.add(lastVal);
        lastVal = r.nextInt(10);
      }
      return a;

    } //end fillForMerge

    public void testMerge(){
      ArrayList<Integer> a = new ArrayList<Integer>();
      ArrayList<Integer> b = new ArrayList<Integer>();
      //a = fillForMerge(17);
      //b = fillForMerge(10);

      System.out.println(a);
      //System.out.println(b);
      //System.out.println(merge(a,b));

      a = fillForMergeSort(17);
      System.out.println(mergeSort(a));
    } //end testMerge
  }
