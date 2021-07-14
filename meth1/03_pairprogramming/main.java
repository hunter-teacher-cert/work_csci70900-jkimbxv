//pair programming exercise
//july 14 2021
//partner: Benson L & Jiyoon K
import java.io.*;
import java.util.*;

public class Main {

  public static void barGraphify(int[] nums){
    for(int i=0; i < nums.length; i++){
      System.out.print(i + ": ");
      for(int j = 0; j < nums[i]; j++){
        System.out.print("=");
      }// end of loop2
      System.out.println();
    }//end of loop1

  }//end of barGraphify

  public static String[][] vertBarGraphify(int[] num){
    int maxOfNum = findMax(num);
    String[][] vertBar = new String[num.length][maxOfNum+1];



  }

  public static int findMax(int[] num){
    int result = 0;
    for (int i = 0, i<num.length ; i++){
      if (num[i]>result){
        result = num[i];
      }

    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    int[] x1 = {0, 1, 2, 3};
    int[] x2 = {1, 0, 3, 2};
    barGraphify(x1);
    System.out.println();
    barGraphify(x2);
  }//end of main
}
