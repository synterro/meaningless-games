import java.util.*;

public class Hangman {

  private static String[] words = {"STRAWBERRY", "UNLIMITED", "WAFFLE", "ECLIPSE", "CACTUS", "POSTER", "SPATULA", "MAGICIAN",
"SUNDAY", "CALCULATOR", "MARTINI"};
  private static Letter[] rightLetters;
  private static char[] wrongLetters;
  private static int chances;
  private static String word;
  private static ArrayList<Character> guessedLetters;

  public Hangman() {


    this.wrongLetters = new char[10];
    this.chances = 10;
    this.guessedLetters = new ArrayList<Character>();


  }


  public static void init() {

    Random rn = new Random();
    word = words[rn.nextInt(500) % words.length];

    rightLetters = new Letter[word.length()];
    for (int i = 0; i < rightLetters.length; i++) {
      rightLetters[i] = new Letter(word.charAt(i));
    }



  }


  public static void displayPic() {
    switch (chances) {
      case 10:
        System.out.println("");
      break;
      case 9:
        System.out.println("===============");
      break;
      case 8:
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 7:
        System.out.println("---------");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 6:
        System.out.println("---------");
        System.out.println("|        |");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 5:
        System.out.println("---------");
        System.out.println("|        |");
        System.out.println("|        O");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 4:
        System.out.println("---------");
        System.out.println("|        |");
        System.out.println("|        O");
        System.out.println("|       { }");
        System.out.println("|");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 3:
        System.out.println("---------");
        System.out.println("|        |");
        System.out.println("|        O");
        System.out.println("|      /{ }");
        System.out.println("|");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 2:
        System.out.println("---------");
        System.out.println("|        |");
        System.out.println("|        O");
        System.out.println("|      /{ }\\");
        System.out.println("|");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 1:
        System.out.println("---------");
        System.out.println("|        |");
        System.out.println("|        O");
        System.out.println("|      /{ }\\");
        System.out.println("|       / ");
        System.out.println("|");
        System.out.println("===============");
      break;
      case 0:
        System.out.println("---------");
        System.out.println("|        |");
        System.out.println("|        O");
        System.out.println("|      /{ }\\");
        System.out.println("|       / \\");
        System.out.println("|");
        System.out.println("===============");
        System.out.println("\nYou lose!");
        System.exit(0);
      break;
    }
    System.out.println("");
    displayWords();
    return;
  }

public static void displayWords() {
  int totalRight = 0;
  for (int i = 0; i < rightLetters.length; i++) {

    if (rightLetters[i].isGuessed==true) {
      System.out.print(rightLetters[i].letter + " ");
      totalRight++;
    }
    else {
      System.out.print("__ ");
    }

  }
  System.out.println("\n");
  System.out.println("Wrong letters:");
  for (int i = 0; i < wrongLetters.length; i++) {
    if (wrongLetters[i] >= 'A' && wrongLetters[i] <= 'Z') {
      System.out.println(wrongLetters[i]);
    }

  }
System.out.println("\n");
  if (totalRight == rightLetters.length) {
    System.out.println("Congratulations! You won!");
    System.exit(0);
  }

  return;
}

public static void guess(String line) {
  String[] args = line.split(" ");
  if (args.length!=2) {
    System.out.println("Invalid command");
    return;
  }
  else if (args[1].length()!=1) {
    System.out.println("Invalid command: not a letter");
    return;
  }

  char answer = args[1].toUpperCase().charAt(0);
  if (answer <'A' || answer >'Z') {
    System.out.println("Invalid command: not a letter");
    return;
  }

  if (guessedLetters.contains(answer)) {
    System.out.println("Letter already guessed: try again!");
    return;
  }

  else {
    guessedLetters.add(answer);
  }

  int totalGuessed = 0;
  for (int i = 0; i < rightLetters.length; i++) {

    if (rightLetters[i].letter==answer) {
      rightLetters[i].isGuessed = true;
      totalGuessed++;
    }

  }

  if (totalGuessed == 0) {
    System.out.println("Wrong! You just lost a chance\n");
    wrongLetters[10-chances] = answer;
    chances--;

    if (chances == 0) {
      displayPic();
    }
    System.out.println("Chances left: " + chances + "\n");

  }

  displayPic();

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
          System.out.println("");
					byeCommand();
					break;
				case "help":
          System.out.println("");
					helpCommand();
					break;
				case "guess":
          System.out.println("");
					guess(line);
					break;
				case "display":
          System.out.println("");
					displayPic();
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
  System.out.println("GUESS <letter>");
  System.out.println("DISPLAY");

}

  public static void main(String[] args) {
    Hangman hangman = new Hangman();
    init();
    displayWords();
    computeEngine();
  }
}
