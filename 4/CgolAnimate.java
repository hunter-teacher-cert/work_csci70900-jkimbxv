import java.io.*;
import java.util.*;

/*
Dwayne, Jiyoon, and Benson
*/

public class CgolAnimate{
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

  //figures out if cell should be alive or dead depending on number of neighbors
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
  }

// ^ Levene
//animates the board to paint over the previous board then display
public static void animate(char[][] board,int frame) {
  //clear screen, place cursor at origin (upper left)
  System.out.print("[2J\n");
  System.out.print("[0;0H\n");
  printBoard(board);
  System.out.println("Gen "+frame);
  delay(1000);
}
//tofr told us to kinda ignore so that is what i shall do
public static void delay(int n) {
  try {
    Thread.sleep(n);
  }
  catch(InterruptedException e) {}
}

  //main game play function
  public static void main( String[] args )
  {
    //Initialize empty board

    char[][] board;
    board = createNewBoard(15,15);
    System.out.println("Empty Board:");
    printBoard(board);
    System.out.println("--------------------------\n\n");

    //breathe life into some cells:

    //Static
    setCell(board, 1, 1, 'X');
    setCell(board, 2, 1, 'X');
    setCell(board, 2, 2, 'X');
    setCell(board, 1, 2, 'X');


    //Oscillating
    setCell(board, 8, 13, 'X');
    setCell(board, 9, 13, 'X');
    setCell(board, 10, 13, 'X');
    // setCell(board, 4, 4, 'X');

    //Traveling
    setCell(board, 6, 5, 'X');
    setCell(board, 7, 6, 'X');
    setCell(board, 8, 6, 'X');
    setCell(board, 8, 5, 'X');
    setCell(board, 8, 4, 'X');

    for (int frame = 0; frame < 10; frame++) {
      board = generateNextBoard(board);
      animate(board,frame);
    }

  }//end main()

}//end class
