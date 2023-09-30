package hexlet.code;

import java.util.Scanner;

public abstract class Engine {

    private  String answer;
    private final int[] generatedNumbers;
    private final Scanner scannerBrainGame;
    private String userName;

    public static final int MIN_NUMBER_RANDOM = 1;
    public static final int MAX_NUMBER_RANDOM = 101;

    protected static final  int MAX_COUNT_ROUND = 3;

    protected Engine(Scanner scannerBrainGameForSet) {
        this.scannerBrainGame = scannerBrainGameForSet;
        this.generatedNumbers = new int[2];
    }

    public final void startGame() {
        var roundCorrect = 0;

        greetUser();
        generateDescriptionTask();

        while (roundCorrect < MAX_COUNT_ROUND) {
            generateNumbers();
            createQuestion();
            readAnswer();
            generateTextResultRound(checkAnswer());

            if (checkAnswer()) {
                roundCorrect += 1;
            } else {
                break;
            }
        }

        if (roundCorrect == MAX_COUNT_ROUND) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }

    public  abstract void createQuestion();

    public abstract boolean checkAnswer();

    public abstract void generateDescriptionTask();

    public final void generateTextResultRound(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(." + generateHelperStringForYesNo());
            System.out.println("Let's try again, " + getUserName() + "!");
        }
    };
    public final String generateHelperStringForYesNo() {
        if (!checkAnswer() && getAnswer().equals("yes")) {
            return "Correct answer was '" + "no" + "'";
        } else if (!checkAnswer() && getAnswer().equals("no")) {
            return "Correct answer was '" + "yes" + "'";
        }
        return "";
    };

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
        return userName;
    }

    public final void generateNumbers() {
        Utils generatorNumbersUtil = new Utils();

        for (var i = 0; i < generatedNumbers.length; i++) {
            generatedNumbers[i] = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM,MAX_NUMBER_RANDOM);
        }
    }

    public final int getGeneratedNumber(int positionNumber) {
        return generatedNumbers[positionNumber];
    }

    public final void greetUser() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        this.userName = scannerBrainGame.next();
        System.out.println("Hello, " + userName + "!");
    }
}
