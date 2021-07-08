import java.io.*;
import java.util.*;
import java.util.Scanner;

public class GradeBookDriver {
  public static void main(String[] args){
    GradeBook newbook = new GradeBook();
    newbook.addAssignment("hw1",90);
    newbook.addAssignment("hw2",94);
    newbook.addAssignment("hw3",92);
    newbook.addAssignment("test",80);
    newbook.addAssignment("lab",85);
    newbook.display();
    System.out.println("--------------");
    newbook.removeByName("hw1");
    newbook.display();

  }
}
