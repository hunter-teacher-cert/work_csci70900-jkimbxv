import java.io.*;
import java.util.*;

public class Knights{


  // the board is of ints rather than chars like the maze
  private int[][] board;
  private int rows = 5;
  private int cols = 5;
  private int size=5;

  //magic java code to do stuff i had to look up anyway
  private String clearScreen="[0;0H\n";

  private void delay(int n){
    try {Thread.sleep(n);}
    catch(InterruptedException e)
    {}
    }

    public Knights(int size){
      rows = size;
      cols = size;
      this.size=size;
      int row,col;

      // Notice that the board is 4 bigger in both directions with 0's
      // in the middle and a 2 row/col border of -1.
      //similar to our maze, the -1 sets up a "wall" to avoid an IOOB error
      board = new int[cols+4][rows+4];
      for (row = 0; row < rows+4; row++){
        for (col = 0; col < cols+4 ; col++){
          board[col][row] = -1;
        }
      }
      for (row = 2; row < rows+2; row++){
        for (col = 2; col < cols+2 ; col++){
          board[col][row] = 0;
        }
      }
    }

    public String toString(){
      int row,col;
      int value;
      String result = "";
      for (row = 0; row < rows+4; row++){
        for (col = 0; col < cols+4; col++){
          value = board[col][row];

          // Why do we have this if as opposed to
          // just adding the next value to the string?
          //A: to format 2 digit vs 1 digit numbers
          if (value < 10 && value >= 0){
            result = result + "0" + value+ " ";
          } else {
            result = result + value + " ";
          }
        }
        result = result +"\n";
      }
      return result;
    }

    public boolean solve(int col,int row, int count){
      boolean solved = false;
      //count++;
      // This should return true when we've solved the problem. What should CHANGETHIS be?
      //A: (rows * cols)
      // in the maze we knew we were done when we found the exit. here, when do we know when we're done?
      //A: when we've visited all the spaces
      // HINT: you have an nxn board and are done when you've visited every board location
      if (count>(rows*cols)){
        System.out.println(this);
        return true;
      }

      // this should return false when we're at an illegal locaiton
      // change CHANGETHIS to the appropriate boolean
      if (board[col][row] == -1){//trying to go outside of the board therefore return false
        //System.out.println("hit wall");
        return false;
      }
      if (board[col][row] > 0){ //if you've visited before; not viable space therefore return false
      //System.out.println("been here");
      return false;
    }

    // what do we put into the board
    board[col][row]=count;
    count++;
    delay(1);
    System.out.println(clearScreen+this);


    // Here we need to do try to do the 8 recursive calls
    // one for each knight's move.
    // Add the recursive calls here

    solved = solve(col+1,row+2,count);

    if (!solved){
      solved = solve(col-1,row+2,count);
      //System.out.println("Solve 1");
    }
    if (!solved){
      solved = solve(col+1,row-2,count);
      //System.out.println("Solve 2");
    }
    if (!solved){
      solved = solve(col-1,row-2,count);
      //System.out.println("Solve 3");
    }
    if (!solved){
      solved = solve(col+2,row-1,count);
      //System.out.println("Solve 4");
    }
    if (!solved){
      solved = solve(col+2,row+1,count);
      //System.out.println("Solve 5");
    }
    if (!solved){
      solved = solve(col-2,row-1,count);
      //System.out.println("Solve 6");
    }
    if (!solved){
      solved = solve(col-2,row+1,count);
      //System.out.println("Solve 7");
    }

    // Here we unset where we were for the backtracking

    board[col][row]=0;
    count--; //need to be able to back track
    return solved;
  }




}
