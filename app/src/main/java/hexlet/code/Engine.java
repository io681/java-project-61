package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final Scanner SCANNER_ENGINE = new Scanner(System.in);

    public static final int MIN_NUMBER_RANDOM = 1;
    public static final int MAX_NUMBER_RANDOM = 101;
    public static final  int MAX_COUNT_ROUND = 3;
    public static final String[] STRUCTURE_ROUND = {"QuestionOne", "CorrectResultOne"};
    public static final int POSITION_QUESTION_ONE = 0;
    public static final int POSITION_CORRECT_RESULT_ONE = 1;

    public static void runGame(String[][] currentGameData, String ruleGame) {
        var roundCorrect = 0;

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String currentUserName = getScannerBrainGame().next();
        System.out.println("Hello, " + currentUserName + "!");

        System.out.println(ruleGame);

        while (roundCorrect < MAX_COUNT_ROUND) {
            System.out.println("Question: " + currentGameData[roundCorrect][POSITION_QUESTION_ONE]);
            String currentAnswerUser = getScannerBrainGame().next();
            String correctAnswerGame = currentGameData[roundCorrect][POSITION_CORRECT_RESULT_ONE];
            boolean resultCheck = correctAnswerGame.equals(currentAnswerUser);

            if (resultCheck) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + currentAnswerUser + "'" + " is wrong answer ;(."
                        + "Correct answer was '" + correctAnswerGame + "'");
                System.out.println("Let's try again, " + currentUserName + "!");
            }

            if (resultCheck) {
                roundCorrect += 1;
            } else {
                return;
            }
        }

        System.out.println("Congratulations, " + currentUserName + "!");

        getScannerBrainGame().close();
    }

    public static Scanner getScannerBrainGame() {
        return SCANNER_ENGINE;
    }
}
