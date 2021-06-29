import java.io.*;
import java.util.*;
import java.util.Arrays;

public class Arrays1{
    public static void main(String[] args){
        printArray(sieve(100));
        Arrays.toString(sieve(100));
    }
    //exercise 1.1
    public static double[] powArray(double[] a,int n){
      for (int i = 0; i<a.length; i++){
        a[i]=Math.pow(a[i],n);
      }
      return a;
    }
    //exercise 1.2
    public static int[] histogram(int[] a, int numCounter){
      int max = 100; //preset value because max value is 99
      int[] counts = new int[numCounter];
      for (int i = 0; i < a.length; i++) {
        int index = (a[i]*numCounter)/max;
        System.out.println(index);
        counts[index]++;
      }
      return counts;
    }
    //exercise 4
    public static int indexOfMax(int[] a){
      int result=-1;
      int currMax = a[0];
      for (int i = 0; i <a.length; i++){
        if (a[i]>currMax){
          result = i;
          currMax = a[i];
        }
      }
      return result;
    }

    //exercise 5
    public static boolean[] sieve(int n){
      boolean[] result = new boolean[n];
      for (int i = 0; i<n; i++){
        result[i]=true;
      }
      for(int i = 2; i<result.length;i++){
        if(result[i]){
          for (int j = i; j<result.length;j+=i){
            if(j/i==1){
              continue;
            } else{
              result[j] = false;
            }
          }
        }
      }
      return result;
    }

    public static void printArray(boolean[] a) {
      System.out.print("{" + a[0]);
      for (int i = 1; i < a.length; i++) {
        System.out.print(", " + a[i]);
      }
      System.out.println("}");
    }
}
