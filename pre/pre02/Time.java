import java.io.*;
import java.util.*;
public class Time{
  public static void main(String[] args){
    int hour = 21; //doubles changed to ints
    int minute = 1;
    int second = 0;
    System.out.print("Minutes since midnight: ");
    double minSinceMidnight = hour*60 + minute;
    System.out.println(minSinceMidnight);
    System.out.print("Seconds remaining in day: ");
    double secSinceMidnight = minSinceMidnight * 60;
    double totalSecDay = 24*60*60;
    System.out.println(totalSecDay-secSinceMidnight);
    System.out.print("Percentage of day passed: ");
    System.out.println((double) secSinceMidnight/ (double) totalSecDay*100+"%");
    int oldHour = 20;
    int oldMinute = 49;
    int oldSec = 0;
    int minSinceMidnightOld = oldHour * 60 + oldMinute;
    System.out.print("Time spent on this exercise: ");
    System.out.println(minSinceMidnight-minSinceMidnightOld);

  }
}
