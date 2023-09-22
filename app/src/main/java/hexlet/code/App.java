package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    public static final String[] games = {"Even","Calc","GCD"};
    static int numberGame = 2;

    public static String userName;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        for (var game: games) {
            System.out.println(numberGame + " - " + game);
            numberGame += 1;
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int numberGameChoice = Integer.parseInt(scanner.next());

        switch (numberGameChoice){
            case 1:
                greetUser();
                break;

            case 2:
                greetUser();
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

                GameEven gameEven = new GameEven (userName);
                gameEven.startGame();
                break;
            case 3:
                greetUser();
                System.out.println("What is the result of the expression?");

                GameCalc gameCalc = new GameCalc (userName);
                gameCalc.startGame();
                break;
            case  4:
                greetUser();
                System.out.println("Find the greatest common divisor of given numbers.");

                GameGCD gameGCD = new GameGCD (userName);
                gameGCD.startGame();
                break;
            case 0:
                break;
        }

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

