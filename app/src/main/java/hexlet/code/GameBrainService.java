package hexlet.code;

import hexlet.code.games.GameCalc;
import hexlet.code.games.GameEven;
import hexlet.code.games.GameGCD;
import hexlet.code.games.GamePrime;
import hexlet.code.games.GameProgression;

public class GameBrainService implements GameService {
    public static final String[] GAMES = {"Even", "Calc", "GCD", "Progression", "Prime"};
    private static final int START_NUMBER_GAME = 2;

    public final void generateMenu() {
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

    public final void startGameByChoiceNumber(int numberGame) {

        switch (numberGame) {
            case 1:
                GameEven greetNoGames = new GameEven();
                greetNoGames.greetUser();
                break;
            case NUMBER_EVEN:
                GameEven gameEven = new GameEven();
                gameEven.startGame();
                break;
            case NUMBER_CALC:
                GameCalc gameCalc = new GameCalc();
                gameCalc.startGame();
                break;
            case  NUMBER_GCD:
                GameGCD gameGCD = new GameGCD();
                gameGCD.startGame();
                break;
            case  NUMBER_PROGRESSION:
                GameProgression gameProgression = new GameProgression();
                gameProgression.startGame();
                break;
            case  NUMBER_PRIME:
                GamePrime gamePrime = new GamePrime();
                gamePrime.startGame();
                break;
            case 0:
                break;
            default:
                System.out.println("The game number is wrong");
                break;
        }
    }
}
