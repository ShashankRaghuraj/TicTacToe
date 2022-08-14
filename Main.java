import java.util.*;
class Main 
{
  public static void main(String[] args) 
  {
    Scanner reader = new Scanner(System.in);
    char[][] board = 
    {
      {' ','|',' ', '|',' '},
      {'-','-','-','-','-'},
      {' ','|',' ','|',' '},
      {'-','-','-','-','-'},
      {' ','|',' ','|',' '},
    };
    displayBoard(board);
    while(true)
    {

      player1(board);
      System.out.println("\n" + win(board) + "\n");
      if((win(board) == "player 1 wins!") || (win(board) == "player 2 wins!"))
      {
        break;
      }
      else{
        boolean tie = checkForTie(board);
        if(tie == true)
        {
          System.out.println("it was a tie!");
          break;
        }
      }
      player2(board);
      System.out.println("\n" + win(board) + "\n");
      if((win(board) == "player 1 wins!") || (win(board) == "player 2 wins!"))
      {
        break;
      }
      else{
        boolean tie = checkForTie(board);
        if(tie = true)
        {
          System.out.println("it was a tie!");
          break;
        }
      }
    }
  }
  public static void displayBoard(char[][] board)
  {
    for (int i = 0; i < board.length; ++i) {
      for(int j = 0; j < board[i].length; ++j) {
        System.out.print(board[i][j]);
      }
      System.out.println("");
    }
  }
  public static void player1(char[][] board)
  {
      Scanner reader = new Scanner(System.in);
      System.out.print("Player 1, Insert row to place X(1 to 3): ");
      int row = reader.nextInt();
      System.out.print("Player 1, Insert column to place X(1 to 3): ");
      int column = reader.nextInt();
      if(column == 1){
        column = 0;
      }
      else if(column == 2){
        column = 2;
      }
      else if(column == 3){
        column = 4;
      }
      else{
        System.out.println("Enter a value from 1 to 3");
        player1(board);
      }
      if(row == 1){
        row = 0;
      }
      else if(row == 2){
        row = 2;
      }
      else if(row == 3){
        row = 4;
      }
      else{
        System.out.println("Enter a value from 1 to 3");
        player1(board);
      }
       boolean checkSpace = checkSpace(board, row, column);
      if(checkSpace == true){
        System.out.println("This space is already filled. Pick again");
        player1(board);
      }
      else{
        board[row][column] = 'X';
        displayBoard(board);
      }
      
  }
  public static void player2(char[][] board)
  {
      Scanner reader = new Scanner(System.in);
      System.out.print("Player 2, Insert row to place O: ");
      int row = reader.nextInt();
      System.out.print("Player 2, Insert column to place O: ");
      int column = reader.nextInt();
      if(column == 1){
        column = 0;
      }
      else if(column == 2){
        column = 2;
      }
      else if(column == 3){
        column = 4;
      }
      else{
        System.out.println("Enter a value from 1 to 3");
        player1(board);
      }
      if(row == 1){
        row = 0;
      }
      else if(row == 2){
        row = 2;
      }
      else if(row == 3){
        row = 4;
      }
      else{
        System.out.println("Enter a value from 1 to 3");
        player1(board);
      }
      boolean checkSpace = checkSpace(board, row, column);
      if(checkSpace == true){
        System.out.println("This space is already filled. Pick again");
        player2(board);
      }
      else{
        board[row][column] = 'O';
        displayBoard(board);
      }
      
  }
  public static boolean checkSpace(char[][] board, int row, int column)
  {
    if(board[row][column] == 'X' || board[row][column] == 'O')
    {
      return true;
    }
    return false;
  }
  public static String win(char[][] board)
  {
    String xWin = "player 1 wins!";
    String oWin = "player 2 wins!";
    String breakOut = "true";
    //Checks to see if the player wins veritcally
    if( (board[0][0] == 'X' && board[0][2] == 'X' &&  board[0][4] == 'X') || (board[2][0] == 'X' && board[2][2] == 'X' &&  board[2][4] == 'X') || (board[4][0] == 'X' && board[4][2] == 'X' &&  board[4][4] == 'X')  )
    {
      return xWin;
    }
    else if( (board[0][0] == 'O' && board[0][2] == 'O' &&  board[0][4] == 'O') || (board[2][0] == 'O' && board[2][2] == 'O' &&  board[2][4] == 'O') || (board[4][0] == 'O' && board[4][2] == 'O' &&  board[4][4] == 'O')  )
    {
      return oWin;
    }

    //Checks to see if the player wins horizontally
    if((board[0][0] == 'X' && board[2][0] == 'X' &&  board[4][0] == 'X') || (board[0][2] == 'X' && board[2][2] == 'X' &&  board[4][2] == 'X') || (board[0][4] == 'X' && board[2][4] == 'X' &&  board[4][4] == 'X')){
      return xWin;
    }
    else if((board[0][0] == 'O' && board[2][0] == 'O' &&  board[4][0] == 'O') || (board[0][2] == 'O' && board[2][2] == 'O' &&  board[4][2] == 'O') || (board[0][4] == 'O' && board[2][4] == 'O' &&  board[4][4] == 'O')){
      return oWin;
    }
    //checks to see if the player wins left side diagonal
    if((board[0][0] == 'X' && board[2][2] == 'X' &&  board[4][4] == 'X')){
      return xWin;
    }
    else if((board[0][0] == 'O' && board[2][2] == 'O' &&  board[4][4] == 'O')){
      return oWin;
    }
    //checks to see if the player wins right side diagonal
    if((board[0][4] == 'X' && board[2][2] == 'X' &&  board[4][0] == 'X')){
      return xWin;
    }
    else if((board[0][4] == 'O' && board[2][2] == 'O' &&  board[4][0] == 'O')){
      return oWin;
    }
    return " ";
  }
}
