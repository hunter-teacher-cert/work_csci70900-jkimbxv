//Jiyoon Kim and Tiffany Wong

import java.io.*;
import java.util.*;

public class Time {
//instance variables: attributes of this Time object
private int hour;
private int minute;
private double second;

//instantiate a newly-created Time object (aka "instance of class Time") with default value(s)
public Time() {
  this.hour = 0;
  this.minute = 0;
  this.second = 0.0;
}

//instantiate a newly-created Time object with specified value(s)
public Time (int hour, int minute, double second){
  this.hour = hour;
  this.minute = minute;
  this.second = second;
}
//print function for Time
public void printTime(){
  System.out.println(this.hour + ":" + this.minute + ":"+this.second);
}

public int getHour(){
  return this.hour;
}

public int getMinute(){
  return this.minute;
}

public double getSecond(){
  return this.second;
}

//.equals function for Time
//member method of Time class

public boolean equals(Time that) {
    return this.hour == that.hour
        && this.minute == that.minute
        && this.second == that.second;
}
//add methods increments my Time by time of another Time object
public Time add(Time t2) {
    Time sum = new Time();
    sum.hour = this.hour + t2.hour; //adds the hour instance variables of both Time objects together
    sum.minute = this.minute + t2.minute;//adds the minutes instance variables of both Time objects together
    if (sum.minute > 59){  //checks if minutes needs to roll over into 1 hour and then remainder minutes
      sum.hour ++;
      sum.minute = sum.minute%60;
    }
    sum.second = this.second + t2.second;//adds the seconds instance variables of both Time objects together
    if (sum.second > 59.00){//checks if seconds needs to roll over into 1 hour and then remainder minutes
      sum.minute ++;
      sum.second = sum.second%60.00;
    }
    return sum;
}

}//end class
