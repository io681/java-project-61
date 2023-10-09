package hexlet.code;

import hexlet.code.games.GameEven;
import hexlet.code.games.GameCalc;
import hexlet.code.games.GameGCD;
import hexlet.code.games.GamePrime;
import hexlet.code.games.GameProgression;

import java.util.Scanner;

public class App {
    public static  final int NUMBER_EVEN = 2;
    public static  final int NUMBER_CALC = 3;
    public static  final int NUMBER_GCD = 4;
    public static  final int NUMBER_PROGRESSION = 5;
    public static  final int NUMBER_PRIME = 6;
    public static final String[] GAMES = {"Even", "Calc", "GCD", "Progression", "Prime"};
    private static final int START_NUMBER_GAME = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        generateMenu();
        int numberGameChoice = Integer.parseInt(scanner.next());
        startGameByChoiceNumber(numberGameChoice);

        scanner.close();
    }

    public static void generateMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");

        int numberList = START_NUMBER_GAME;

        for (var game: GAMES) {
            System.out.println(numberList + " - " + game);
            numberList += 1;
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }

    public static void startGameByChoiceNumber(int numberGame) {
        switch (numberGame) {
            case 1:
                Cli.greeting();
                break;
            case NUMBER_EVEN:
                GameEven gameEven = new GameEven();
                Engine.startGame(gameEven);
                break;
            case NUMBER_CALC:
                GameCalc gameCalc = new GameCalc();
                Engine.startGame(gameCalc);
                break;
            case  NUMBER_GCD:
                GameGCD gameGCD = new GameGCD();
                Engine.startGame(gameGCD);
                break;
            case  NUMBER_PROGRESSION:
                GameProgression gameProgression = new GameProgression();
                Engine.startGame(gameProgression);
                break;
            case  NUMBER_PRIME:
                GamePrime gamePrime = new GamePrime();
                Engine.startGame(gamePrime);
                break;
            case 0:
                break;
            default:
                System.out.println("The game number is wrong");
                break;
        }
    }

}

