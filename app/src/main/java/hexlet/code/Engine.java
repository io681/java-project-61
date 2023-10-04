package hexlet.code;

import java.util.Scanner;

public class Engine {
    private  String answer;
    private final Scanner scannerBrainGame;
    private String userName;

    public static final int MIN_NUMBER_RANDOM = 1;
    public static final int MAX_NUMBER_RANDOM = 101;
    public static final  int MAX_COUNT_ROUND = 3;

    public static final String[] STRUCTURE_ROUND = {"QuestionOne", "CorrectResultOne"};
    public static final int POSITION_QUESTION_ONE = 0;
    public static final int POSITION_CORRECT_RESULT_ONE = 1;

    public Engine(Scanner scannerBrainGameForSet) {
        this.scannerBrainGame = scannerBrainGameForSet;
    }

    public final void startGame(String[][] dataForCurrentStartGame) {
        var roundCorrect = 0;

        while (roundCorrect < MAX_COUNT_ROUND) {
            System.out.println("Question: " + dataForCurrentStartGame[roundCorrect][POSITION_QUESTION_ONE]);
            readAnswer();
            boolean resultCheck = checkAnswer(getAnswer(),
                    dataForCurrentStartGame[roundCorrect][POSITION_CORRECT_RESULT_ONE]);
            generateTextResultRound(resultCheck, roundCorrect);

            if (resultCheck) {
                roundCorrect += 1;
            } else {
                break;
            }
        }

        if (roundCorrect == MAX_COUNT_ROUND) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }

    public boolean checkAnswer(String answerUser, String answerCorrect) {
        return answerCorrect.equals(answerUser);
    }

    public final void generateTextResultRound(boolean isCorrect, int currentRound) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(."
                    + generateHelperStringForYesNo());
            System.out.println("Let's try again, " + getUserName() + "!");
        }
    }

    public final String generateHelperStringForYesNo() {
        if (getAnswer().equals("yes")) {
            return "Correct answer was '" + "no" + "'";
        } else if (getAnswer().equals("no")) {
            return "Correct answer was '" + "yes" + "'";
        }
        return "";
    }

    public  final void readAnswer() {
        setAnswer(scannerBrainGame.next());
    }

    public final String getAnswer() {
        return answer;
    }

    public final void setAnswer(String answerForSet) {
        this.answer = answerForSet;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void greetUser() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        this.userName = getScannerBrainGame().next();
        System.out.println("Hello, " + getUserName() + "!");
    }

    public Scanner getScannerBrainGame() {
        return this.scannerBrainGame;
    }
}
