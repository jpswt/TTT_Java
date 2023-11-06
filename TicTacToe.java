import java.util.Scanner;

public class TicTacToe {

  static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("\nLet's play tic tac toe");

    char[][] board = {
      { '_', '_', '_' },
      { '_', '_', '_' },
      { '_', '_', '_' },
    };

    printBoard(board);

    for (int i = 0; i < 9; i++) {
      if (i % 2 == 0) {
        System.out.println("Turn : X");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'X';
      } else {
        System.out.println("Turn: O");
        int[] spot = askUser(board);
        board[spot[0]][spot[1]] = 'O';
      }
      printBoard(board);

      int count = checkWin(board);
      if (count == 3) {
        System.out.println("PLAYER X WINS!");
        break;
      } else if (count == -3) {
        System.out.println("PLAYER O WINS!");
        break;
      } else if (i == 8) {
        System.out.println("IT'S A TIE!");
      }
    }

    scan.close();
  }

  public static void printBoard(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      System.out.println("");
      System.out.print("\t");
      for (int j = 0; j < board[i].length; j++) {
        System.err.print(board[i][j] + " ");
      }
      System.out.println("");
    }
    System.out.println("");
  }

  public static int[] askUser(char[][] board) {
    System.out.print("Pick a row number: ");
    int row = scan.nextInt();
    System.out.print("Pick a column number: ");
    int column = scan.nextInt();
    while (board[row][column] != '_') {
      System.out.println("Spot taken, please try again");
      row = scan.nextInt();
      column = scan.nextInt();
    }
    return new int[] { row, column };
  }

  public static int checkWin(char[][] board) {
    int rows = checkRows(board);

    if (Math.abs(rows) == 3) return rows;

    int columns = checkColumns(board);
    if (Math.abs(columns) == 3) return columns;

    int leftDiagonal = checkLDiagonal(board);
    if (Math.abs(leftDiagonal) == 3) return leftDiagonal;

    int rightDiagonal = checkRDiagonal(board);
    if (Math.abs(rightDiagonal) == 3) return rightDiagonal;

    return -1;
  }

  public static int checkRows(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == 'X') {
          count++;
        } else if (board[i][j] == 'O') {
          count--;
        }
      }
      if (Math.abs(count) == 3) {
        return count;
      } else {
        count = 0;
      }
    }
    return count;
  }

  public static int checkColumns(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] == 'X') {
          count++;
        } else if (board[j][i] == 'O') {
          count--;
        }
      }
      if (Math.abs(count) == 3) {
        return count;
      } else {
        count = 0;
      }
    }
    return count;
  }

  public static int checkLDiagonal(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[i][i] == 'X') {
        count++;
      } else if (board[i][i] == 'O') {
        count--;
      }
    }
    return count;
  }

  public static int checkRDiagonal(char[][] board) {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (board[2 - i][i] == 'X') {
        count++;
      } else if (board[i][i] == 'O') {
        count--;
      }
    }
    return count;
  }
}
