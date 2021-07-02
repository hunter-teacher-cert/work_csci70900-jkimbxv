import java.io.*;
import java.util.*;

public class Craps{
    public static void main(String[] args){
        System.out.println("Welcome to Craps! How many rounds would you like to play?");
        Scanner in = new Scanner(System.in);
        int numRounds = in.nextInt();
        for (int i = 1; i<=numRounds;i++){
          System.out.println(round());
        }
    }
    public static int roll(int n){
      //accepts an integer parameter
      //returns a random number between 1 and that number, inclusive
      Random rand = new Random();
      return rand.nextInt(n+1);
    }
    public static int shoot(int numDice, int max){
      //accepts two parameters - a number of dice
      //the maximum value for those dice
      //returns the result of rolling those dice.
      int result = 0;
      for (int i = 1; i<=numDice;i++){
        result = result+roll(max);
      }
      return result;
    }
    public static String round(){
      String result = "You lose";
      int play = shoot(2,6);
      int point = 0;
      if (play == 2 || play == 3 || play == 12){
        result = "Craps. You lose!";
        return result;
      }else if (play == 7 || play == 11){
        result = "Natural. You win!";
        return result;
      }else{
        point = play;
        int temp;
        do{
          temp = shoot(2,6);
          if (temp == play){
            result = "You rolled point. You win!";
            return result;
          }
        }while(temp !=7);

      }
      return result;
    }
}
