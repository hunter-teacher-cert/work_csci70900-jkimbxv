import java.io.*;
import java.util.*;

/**
Dwayne, Jiyoon, and Benson
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
        result[r][c] = '_';
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
  public static int countNeighbors(char[][] board, int r, int c) {
    int numNeighbor = 0;
    /*(r-1,c-1)   (r-1,c)  (r-1,c+1)
      (r, c-1)     (r,c)    (r,c+1)
      (r+1,c-1)   (r+1,c)  (r+1,c+1)
    */
    //checking non-edge cases
    //check edge cases, where r == 0 or board.length -1
    //where c == 0 or or board[0].length-1

    //non corner top row
    if (r==0&& c!=0 &&c!=board[0].length-1){
      //starts at r to prevent going above
      for (int i = r; i<=r+1;i++){
        for (int j = c-1; j<=c+1;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //non corner left column
    else if (c==0&&r!=0&&r!=board.length-1){
      for (int i = r-1; i<=r+1;i++){
        for (int j = c; j<=c+1;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //noncorner bottom row
    else if (r==board.length-1 && c!=0&&c!=board[0].length-1){
      for (int i = r-1; i<=r;i++){
        for (int j = c-1; j<=c+1;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //noncorner right col
    else if (c==board[0].length-1 && r!=0&&r!=board.length-1){
      for (int i = r-1; i<=r+1;i++){
        for (int j = c-1; j<=c;j++){
        if (board[i][j]=='X'){
          numNeighbor++;
          }
        }
      }
    }

    //top left corner
    else if(c==0 && r == 0){
      for (int i = r; i<=r+1;i++){
        for (int j = c; j<=c+1;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //top right corner
    else if(c==board[0].length-1 && r == 0){
      for (int i = r; i<=r+1;i++){
        for (int j = c-1; j<=c;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //bottom left corner
    else if(c==0 && r == board.length-1){
      for (int i = r-1; i<=r;i++){
        for (int j = c; j<=c+1;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //bottom right corner
    else if(c==board[0].length-1 && r == board.length-1){
      for (int i = r-1; i<=r;i++){
        for (int j = c-1; j<=c;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //non edge cases
    else{
      for (int i = r-1; i<=r+1;i++){
        for (int j = c-1; j<=c+1;j++){
          if (board[i][j]=='X'){
            numNeighbor++;
          }
        }
      }
    }

    //Subtract the cell being checked
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
    int neigh = countNeighbors(board, r, c);
    if (neigh <2 || neigh >3){//die if 0 , 1, or 4+ neighbors
      return '_';
    }else if (neigh == 3){ //birth
      return 'X';
    }else if (neigh == 2){ //return current condition
      return board[r][c];
    }else{
      return '-';
    }
  /*
    * A cell with 2 or 3 living neighbours will survive for the next generation.

   Death:
   * Each cell with >3 neighbours will die from overpopulation.

   * Every cell with <2 neighbours will die from isolation.

   Birth:
   * Each dead cell adjacent to exactly 3 living neighbours is a birth cell. It will come alive next generation.
   NOTA BENE:  All births and deaths occur simultaneously. Together, they constitute a single generation
   */
  }


  //generate new board representing next generation
  public static char[][] generateNextBoard(char[][] board) {

    //make new board
    char[][] newBoard = createNewBoard(board.length,board[0].length);
    //loop through new board
    for(int rowNB = 0; rowNB < newBoard.length; rowNB++){
      for (int colNB = 0; colNB < newBoard[0].length;colNB++){
            newBoard[rowNB][colNB] = getNextGenCell(board,rowNB,colNB);
    //      //use countNeighbor to figure out if alive or not
        }
     }
    return newBoard;

    // for(int i = 0; i < r; i++){
    //     for (j = 0; j < j[0].length){

    //     }
    // }


    //should represent the new amount of Xs and Os based on position of living cells
    //if cell next to [r][c] is dead then cell it self is deal
    //if cell next to current cell != 'X' then current cell itself is the '0'
    //
  }

// ^ Levene

  public static void main( String[] args )
  {

    char[][] board;
    board = createNewBoard(5,5);
    printBoard(board);
    System.out.println();
    //breathe life into some cells:
    setCell(board, 0, 0, 'X');
    setCell(board, 0, 1, 'X');
    setCell(board, 0, 2, 'X');
    setCell(board, 3, 2, 'X');
    setCell(board, 3, 3, 'X');
    System.out.println("Gen X:");
    printBoard(board);
    System.out.println("--------------------------\n\n");
    System.out.println("Gen X+1:");
    board = generateNextBoard(board);
    printBoard(board);
    System.out.println("--------------------------\n\n");
    System.out.println("Gen X+2:");
    board = generateNextBoard(board);
    printBoard(board);
    System.out.println("--------------------------\n\n");

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // TASK:
    // Once your initial version is running,
    // try out different starting configurations of living cells...
    // (Feel free to comment out the above three lines.)


    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class
