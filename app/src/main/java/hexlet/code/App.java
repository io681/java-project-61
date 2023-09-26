package hexlet.code;

import hexlet.code.games.GameEven;
import hexlet.code.games.GameCalc;
import hexlet.code.games.GameGCD;
import hexlet.code.games.GamePrime;
import hexlet.code.games.GameProgression;


import java.util.Scanner;

public class App {
    public static final String[] GAMES = {"Even", "Calc", "GCD", "Progression", "Prime"};
    private static final int startNumberGameMenu = 2;

    private static String userName;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        int numberList = startNumberGameMenu;

        for (var game: GAMES) {
            System.out.println(numberList + " - " + game);
            numberList += 1;
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int numberGameChoice = Integer.parseInt(scanner.next());

        switch (numberGameChoice) {
            case 1:
                greetUser();
                break;

            case startNumberGameMenu:
                greetUser();
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

                GameEven gameEven = new GameEven(userName);
                gameEven.startGame();
                break;
            case startNumberGameMenu + 1:
                greetUser();
                System.out.println("What is the result of the expression?");

                GameCalc gameCalc = new GameCalc(userName);
                gameCalc.startGame();
                break;
            case  startNumberGameMenu + 2:
                greetUser();
                System.out.println("Find the greatest common divisor of given numbers.");

                GameGCD gameGCD = new GameGCD(userName);
                gameGCD.startGame();
                break;
            case  startNumberGameMenu + 3:
                greetUser();
                System.out.println("What number is missing in the progression?");

                GameProgression gameProgression = new GameProgression(userName);
                gameProgression.startGame();
                break;
            case  startNumberGameMenu + 4:
                greetUser();
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

                GamePrime gamePrime = new GamePrime(userName);
                gamePrime.startGame();
                break;
            case 0:
                break;
            default:
                System.out.println("The game number is wrong");
                break;
        }

        scanner.close();
    }

    public static void greetUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
}

