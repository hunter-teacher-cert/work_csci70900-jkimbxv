/**
 * Mancala
 * Team
 * Jiyoon Kim
 * Marina Moshchenko
 * Eric Liu
 **/

import java.io.*;
import java.util.*;
import java.util.Scanner;
//check if there are stones in any pit
//player picks some pit on their side 0-5
//empty chosen pit
//distribute stones from pit
//ai picks some pit 7-12
//empty chosen pit
//distribute stones from pit
//keep going until you run out of stones in the pit

public class Mancala{
  //0's at indices 6 and 13 to represent mancala
  public static int[] gameBoard = {4, 4, 4, 4, 4, 4, 0, 4, 4, 4, 4, 4, 4, 0};

  //is a user userTurn
  //asks user which pit to take from
  public static boolean userTurn(){

    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
    System.out.println("User, Which pit to move from?: ");
    int pit = myObj.nextInt();  // Read user input

    while(gameBoard[pit] == 0) { // check valid move, loop if user input is invalid
      System.out.println("No stones there. Pick a different pit: ");
      pit = myObj.nextInt();  // Read user input
    }//end while

    int stonesInPit = gameBoard[pit];//grab how many stones are in the pit user picked
    gameBoard[pit] = 0;
    pit++;
    while (stonesInPit>0) {
      if (pit==13) { //makes sure not to drop in opponent's mancala
        pit=0; //loops to my pit
      }
      gameBoard[pit] = gameBoard[pit]+1;
      pit++;
      stonesInPit--;
    }
    return (pit == 6); //returns boolean to check if last piece went in manacala
  }

  //is a user aiTurn
  //asks user which pit to take from
  public static boolean aiTurn(){
    //display gameboard so player can see goes here
    Random random = new Random();
    int pit = random.nextInt(6)+7;
    while(gameBoard[pit] == 0) { // check if AI valid move
      if (noAIMove()){
        break;
      }
       pit = random.nextInt(6)+7;// Generate new AI move that's not empty
       System.out.println(pit);
    }//end while
    System.out.println("AI's turn is "+pit);

    int stonesInPit = gameBoard[pit];//grab how many stones are in the pit user picked
    //loop proceeds until stonesInPit == 0
    //increments gameboard elements
    gameBoard[pit]=0; //empties the pit user picked
    //while loop distributes the stones from the pit
    while (stonesInPit>0){
      if (pit==13){ //checks if at end of array
        pit=0;//loops back to first pit on opponents side
      }else if (pit==6){ //makes sure not to drop in opponent's mancala
        pit=7; //loops to ai pit start
      }else{ //if not at the end
        pit++; //move on to next pit
      }
      gameBoard[pit]++;
      stonesInPit--;
    }
    return (pit == 13); //returns boolean to check if last piece went in manacala
    }

  /**
	* Displays the current gameBoard
  * @return None
	*/
  public static void displayBoard() {

    //Print gameboard out in full Array without formatting
    //System.out.println(Arrays.toString(gameBoard));

    // Prints AI gameboard in two row format with mancala on the left side
    System.out.print(gameBoard[13] + " ");
    for (int i = 12; i > 6; i--) {
       System.out.print(gameBoard[i]+ " ");
    }

    // Prints user gameboard in two row format with mancala on the right side
    System.out.print("\n  ");
    for (int i = 0; i < 6; i++) {
       System.out.print(gameBoard[i]+" ");
    }
    System.out.println(" " + gameBoard[6] + " ");

  }//end displayBoard


  /**
	* checkWinner
  *
  * @return int 0 user won, 1 AI won, 2 if tie, -1 if no winner
	*/
	public static int checkWinner() {
    //check if sum of the two mancalas are 48 meaning all stones dropped
    if ( (gameBoard[6] + gameBoard[13]) == 48) {
      if (gameBoard[6] > gameBoard[13]) {
        System.out.println("User player wins with " + gameBoard[6] + " stones.");
        return 0;
      } else if (gameBoard[6] < gameBoard[13]) {
        System.out.println("AI wins with " + gameBoard[13] + " stones.");
        return 1;
      } else {
        System.out.println("TIE! with 24 stones each.");
        return 2;
      }
    } else { // no winner so return -1
        return -1;
    }

	}//end checkWinner

public static boolean noUserMove(){
  int currSum = 0;
  for (int i = 0; i<6;i++){
    currSum+=gameBoard[i];
  }
  return (currSum==0);
}
public static boolean noAIMove(){
  int currSum = 0;
  for (int i = 7; i<13;i++){
    currSum+=gameBoard[i];
  }
  return (currSum==0);
}

  public static void main(String[] args){

    while(!noUserMove() || !noAIMove()) {
      //setup gameBoard/display it
      displayBoard();
      boolean aiManc;


      boolean userManc = userTurn();
      // Check if there is a winner
      if ( checkWinner() == 0 ) {
        break;
      }

      displayBoard();
      aiManc = aiTurn();
      // Check if there is a winner
      if ( checkWinner() == 1) {
        break;
      }
      System.out.println("game over");
    }//end while gameloop


    //check if still user turn / loop back if it is

    //redistribute stones
    //display board
    //check if still user turn/loop back if ai


  }

}//end Mancala
