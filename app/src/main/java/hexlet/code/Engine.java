package hexlet.code;

import hexlet.code.games.Games;

import java.util.Scanner;

public class Engine {
    private final Scanner scannerBrainGame;

    public static final int MIN_NUMBER_RANDOM = 1;
    public static final int MAX_NUMBER_RANDOM = 101;
    public static final  int MAX_COUNT_ROUND = 3;
    public static final String[] STRUCTURE_ROUND = {"QuestionOne", "CorrectResultOne"};
    public static final int POSITION_QUESTION_ONE = 0;
    public static final int POSITION_CORRECT_RESULT_ONE = 1;

    public Engine() {
        this.scannerBrainGame = new Scanner(System.in);
    }

    public final void startGame(Games currentGame) {
        var roundCorrect = 0;
        String userNameForCurrentGame = greetUser();

        System.out.println(currentGame.getRuleGame());
        currentGame.generateDataForGame();

        while (roundCorrect < MAX_COUNT_ROUND) {
            System.out.println("Question: " + currentGame.getDataForGame()[roundCorrect][POSITION_QUESTION_ONE]);
            String currentAnswer = getScannerBrainGame().next();
            boolean resultCheck = checkAnswer(currentAnswer,
                    currentGame.getDataForGame()[roundCorrect][POSITION_CORRECT_RESULT_ONE]);
            generateTextResultRound(resultCheck, currentAnswer, userNameForCurrentGame);

            if (resultCheck) {
                roundCorrect += 1;
            } else {
                break;
            }
        }

        if (roundCorrect == MAX_COUNT_ROUND) {
            System.out.println("Congratulations, " + userNameForCurrentGame + "!");
        }

        getScannerBrainGame().close();
    }

    public final boolean checkAnswer(String answerUser, String answerCorrect) {
        return answerCorrect.equals(answerUser);
    }

    public final void generateTextResultRound(boolean isCorrect, String answerForTextResult, String UserNameForTextResult) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + answerForTextResult + "'" + " is wrong answer ;(."
                    + generateHelperStringForYesNo(answerForTextResult));
            System.out.println("Let's try again, " + UserNameForTextResult + "!");
        }
    }

    public final String generateHelperStringForYesNo(String answerForGenerateHelperStringForYesNo) {
        if (answerForGenerateHelperStringForYesNo.equals("yes")) {
            return "Correct answer was '" + "no" + "'";
        } else if (answerForGenerateHelperStringForYesNo.equals("no")) {
            return "Correct answer was '" + "yes" + "'";
        }
        return "";
    }

    public final String greetUser() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String currentUserName = getScannerBrainGame().next();
        System.out.println("Hello, " + currentUserName + "!");
        return currentUserName;
    }

    public final Scanner getScannerBrainGame() {
        return this.scannerBrainGame;
    }
}
