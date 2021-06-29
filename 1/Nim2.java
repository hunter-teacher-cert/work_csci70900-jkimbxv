import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Random;

//This is me trying to code from scratch to make sure I understand
//all the components. 

public class Nim2{

public static int stonesCurr = 12;

public static void aiTurn(){
  int max = 3;
  int min = 1;
  int aiMove = (int)Math.floor(Math.random()*(max-min+1)+min);
  stonesCurr -= aiMove;
  System.out.println("AI removed "+aiMove+" stones. " + stonesCurr + " left.");
}

public static void userTurn(){
    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    boolean validInput = false;
    while (!validInput){
      System.out.println("How many stones remove? ");
      int userMove = myObj.nextInt();  // Read user input
      if (userMove<4 && userMove>0){
        validInput = true;
      }else{
        System.out.println("Invalid input. Input must be 1, 2, or 3");
      }
    }
    System.out.println("How many stones remove? ");
    int userMove = myObj.nextInt();  // Read user input
    stonesCurr -= userMove;
    System.out.println("User removed "+userMove+" stones. " + stonesCurr + " left.");
}


public static void main(String[] args) {
  while (stonesCurr >0){
    userTurn();
    if (stonesCurr == 0){ //checks to see if user had winning move
      System.out.println("User Wins!");
      break;
    }
    aiTurn();
    if (stonesCurr == 0){ //checks to see if AI had winning move
      System.out.println("User Loses!");
      break;
    }
  }

}
}
