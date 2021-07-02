import java.io.*;
import java.util.*;

public class Loops{
    public static void main(String[] args){
      //exercise 5.5
      double i = 0.1;
      while (i<=100.0){
        check(i);
        i = i*10.0;
      }
      //as the x in e^x increases, the difference
      //in values between myexp() and Math.exp()
      //increases drastically. By e^100, there is
      //a 10^22 fold difference.
      System.out.println();
      //exercise 5.6
      double j = 0.1;
      while (j<=100.0){
        check(j*-1);
        j = j*10.0;
      }
      //this accuracy is awful. By the time it hit -10
      //the myexp() gave the wrong answer. It deviated
      //and did not even give a fraction.
    }
    //exercise 3
    public static double powerLoop(double base, double exp){
      double result = 1;
      while (exp >0){
        result = result * base;
        exp--;
      }
      return result;
    }

    //exercise 4
    public static double factorial(double n){
      double result = 1;
      while (n > 0){
        result = result*n;
        n--;
      }
      return result;
    }
    //exercise 5.1
    public static double myexp(double x, double n){//assumes int exponent
      double result=0;
      int i = 0;
      while (i<=n){
        result = result+(powerLoop(x,i)/factorial(i));
        i++;
      }
      return result;
    }
    //exercise 5.2
    public static double myexp2(double x, double n){//assumes int exponent
      double num=1;
      double denom=1;
      double result = 1;
      int i = 1;
      while (i<=n){
        num = num*x;
        denom = denom*i;
        result = result + (num/denom);
        i++;
      }
      return result;
    }
    //exercise 5.3
    public static void check(double x){
      System.out.print(x + "\t");
      System.out.print(myexp(x,20)+"\t"); //exercise 5.4
      System.out.println(Math.exp(x));
    }

}
