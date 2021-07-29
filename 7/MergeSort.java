import java.io.*;
import java.util.*;
import java.util.Arrays;

public class MergeSort {

  public static int[] mergeSplit(int[] info){
    if (info.length <=1){
      System.out.println("end of recursion");
      return info;
    }
    int mid = (int)info.length/2;
    int[] leftArr = Arrays.copyOfRange(info, 0, mid);
    System.out.println(Arrays.toString(leftArr));
    int[] rightArr = Arrays.copyOfRange(info,mid,info.length);
    System.out.println(Arrays.toString(rightArr));
    return merge(mergeSplit(leftArr),mergeSplit(rightArr));
  }
  public static int[] merge(int[] left, int[] right){
    int iLeft = 0;
    int iRight = 0;
    int[] result = onew int[left.length + right.length];
    for (int i = 0; i<result.length; i++){
      System.out.println(i);
      if (left[iLeft] <= right[iRight]){
        result[i] = left[iLeft];
        iLeft++;
      }else{
        result[i] = right[iRight];
        iRight++;
      }
    }
    return result;
  }
  public static void main(String[] args){
    int[] testArr = {4, 6, 1, 9, 2, 0};
    System.out.println(mergeSplit(testArr));

  }
}
