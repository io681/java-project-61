package hexlet.code;

import java.util.Scanner;

public class App {
    public static final int COUNT_GAMES = 1;
    public static final String NAME_GAME = "Even";

    public static String userName;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println((COUNT_GAMES + 1)  + " - " + NAME_GAME);
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int numberGame = Integer.parseInt(scanner.next());

        switch (numberGame){
            case 1:
                greetUser();
                break;

            case 2:
                greetUser();
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                GameEven gameEven = new GameEven (userName);
                gameEven.startGame();
            case 0:
                break;
        }

//        if (numberGame == 1) {
//            greetUser();
//        }
//        if (numberGame == 2) {
//            greetUser();
//            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
//        }
        scanner.close();
    }

    public static void greetUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}

