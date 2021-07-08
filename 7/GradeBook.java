import java.io.*;
import java.util.*;
import java.util.Scanner;

public class GradeBook {
  private ArrayList<String> assignments;
  private ArrayList<Integer> grades;

  //constructor makes empty gradebook
  public GradeBook(){
    assignments = new ArrayList<String>();
    grades = new ArrayList<Integer>();
  }

  //teacher can add grade and assignment at once
  public void addAssignment(String name, int grade){
    assignments.add(name);
    grades.add(grade);
  }

  //teacher can remove grade as needed
  public void removeByName(String name){
    //loop to look for the assignment by name
    int nameIndex = -1;
    for (int i = 0; i < assignments.size(); i++){
      if (assignments.get(i)==name){
        nameIndex = i;
      }
    }
    //remove said assignment
    assignments.remove(nameIndex);
    //remove said grade
    grades.remove(nameIndex);
  }

  public void display(){
    for (int i = 0; i < assignments.size(); i++){
      System.out.println("Name: "+ assignments.get(i)+" Grade: "+ grades.get(i));
    }
  }



}//class SuperArrayDriver
