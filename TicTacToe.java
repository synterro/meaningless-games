import java.util.*;

public class TicTacToe {
  private static char[][] board;


  public TicTacToe() {
    this.board = new char[3][3];

  }
public static void displayBoard() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j > 0) {
          System.out.print("|");
        }
        if (board[i][j]=='\u0000') {
          System.out.print("*");
        }
        else {
          System.out.print(board[i][j]);
        }

      }
      System.out.println();
      if (i < 2) {
        System.out.println("------");
      }
    }
  }

public static void computeEngine() {

		Scanner scan = new Scanner(System.in);

		// Display prompt
		System.out.printf("> ");

		// Read from standard input until EOF
		while (scan.hasNextLine()) {
			// Process line
			String line = scan.nextLine();
			String command = line.split(" ")[0].toLowerCase();

			switch (command) {
				case "":
					break;
				case "bye":
					byeCommand();
					break;
				case "help":
					helpCommand();
					break;
				case "place":
					placeCommand(line);
					break;
				case "display":
					displayBoard();
					break;
				case "forfeit":
					forfeitCommand();
					break;
				default:
					System.out.printf("invalid command\n");
			}

			System.out.printf("\n> ");
		}

		System.out.printf("\nbye\n");
	}

  public static void byeCommand() {

		System.out.printf("bye\n");
		System.exit(0);
	}
public static void helpCommand() {

  System.out.println("BYE");
  System.out.println("HELP");
  System.out.println("");
  System.out.println("PLACE [X] [Y] (where X and Y are both between 0 and 2)");
  System.out.println("DISPLAY");
  System.out.println("FORFEIT");
}

public static void placeCommand(String line) {
  String[] args = line.split(" ");
  if (args.length != 3) {
    //to do
    System.out.printf("Invalid number of arguments\n");
    return;
  }
  int x = 0;
  int y = 0;
  try {
    x = Integer.parseInt(args[1]);
    y = Integer.parseInt(args[2]);
  } catch (NumberFormatException e) {
    System.out.printf("Invalid arguments: arguments must be integers\n");
    System.exit(1);
  }
  try {
    if (board[x][y]=='x' || board[x][y]=='o') {
      System.out.printf("Invalid move: square already occupied\n");
      return;
    }
    else {
      board[x][y] = 'x';
      checkBoard();
    }
  } catch(Exception e) {
    System.out.printf("Invalid command");
    return;
  }

  computerTurn();
  displayBoard();
  return;
}

public static void computerTurn() {
  boolean isNotDecided = true;
  while (isNotDecided) {
    Random rn = new Random();
    int keyX = rn.nextInt(100) % 3;
    int keyY = rn.nextInt(100) % 3;

    if (board[keyX][keyY]=='\u0000') {
      board[keyX][keyY] = 'o';
      break;
    }

  }


  checkBoard();
}

public static void checkBoard() {
  if (board[0][0] == board[0][1] && board[0][0] == board[0][2]) {
    if (board[0][0]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[0][0]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  else if (board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
    if (board[1][0]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[1][0]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  else if (board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
    if (board[2][0]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[2][0]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  else if (board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
    if (board[0][0]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[0][0]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  else if (board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
    if (board[0][1]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[0][1]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  else if (board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
    if (board[0][2]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[0][2]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  else if (board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
    if (board[0][0]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[0][0]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  else if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
    if (board[2][0]=='x') {
      displayBoard();
      System.out.println("You win! Good job.");
      System.exit(0);
    }
    else if (board[2][0]=='o') {
      displayBoard();
      System.out.println("Sorry! Computer wins.");
      System.exit(0);
    }
  }
  int numOfEmptySpots = 0;
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
      if (board[i][j]=='\u0000') {
        numOfEmptySpots++;
      }
    }
  }

  if (numOfEmptySpots==0) {
    displayBoard();
    System.out.println("Draw! Thank you for playing.");
    System.exit(0);
  }
  return;
}

public static void forfeitCommand() {
  System.out.println("Computer wins! You lose. Better luck next time.");
  byeCommand();
}

  public static void main(String[] args) {
    System.out.println("TIC TAC TOE");
    System.out.println("You be X and I'll be O!");
    TicTacToe tic = new TicTacToe();
    computeEngine();
  }
}
