import java.io.*;
import java.util.*;

/**
   The Rules of Life:
   Survivals:
   * A cell with 2 or 3 living neighbours will survive for the next generation.
   Death:
   * Each cell with >3 neighbours will die from overpopulation.
   * Every cell with <2 neighbours will die from isolation.
   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
*/

public class Cgol
{

  //initialize empty board (all cells dead)
  public static char[][] createNewBoard(int rows, int cols) {
    char[][] result = new char[rows][cols];
    for (int r = 0; r < result.length; r++){
      for (int c = 0; c< result[r].length; c++){
        result[r][c] = 'O';
      }
    }
    return result;
  }


  //print the board to the terminal
  public static void printBoard(char[][] board) {
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        System.out.print(board[i][j]+" ");
      }System.out.println();
    }
    System.out.println();
  }


  //set cell (r,c) to val
  public static void setCell(char[][] board, int r, int c, char val){
    board[r][c] = val;
  }


  //return number of living neigbours of board[r][c]
  public static int countNeighbours(char[][] board, int r, int c) {
    int numNeighbor = 0;
    if (r==0 || c == 0 //checking edge cases
    || r == board.length-1
    || c==board[0].length-1){
      //edge cases

    }else{//checking non-edge cases
      for (int i = r-1; i<=r+1;i++){
        for (int j = c-1; j<=c+1;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //checks "self" to make sure you don't double count
    if (board[r][c]=='X'){
      numNeighbor--;
    }
    return numNeighbor;
  }


  /**
     precond: given a board and a cell
     postcond: return next generation cell state based on CGOL rules
     (alive 'X', dead ' ')
  */
  public static char getNextGenCell(char[][] board,int r, int c) {
    return 'a';

  }


  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {
    char[][] result = {{'a'},{'b'}};
    return result;
  }


  public static void main( String[] args )
  {

    char[][] board;
    board = createNewBoard(25,25);
    printBoard(board);
    System.out.println();
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 1, 0, 'X');
    printBoard(board);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    board = generateNextBoard(board);
    System.out.println("Gen X+1:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
