package hexlet.code;

import hexlet.code.utils.GeneratorRandomGameBrain;

import java.util.Scanner;

import static hexlet.code.utils.GeneratorRandom.MAX_NUMBER_RANDOM;

public abstract class Engine {

    private  String answer;
    private final int[] generatedNumbers;
    private final Scanner scanner;
    private String userName;

    protected static final  int MAX_COUNT_ROUND = 3;

    protected Engine() {
        this.scanner = new Scanner(System.in);
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

    public void generateTextResultRound(boolean isCorrect) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(.");
            System.out.println("Let's try again, " + getUserName() + "!");
        }

    }

    public  final void readAnswer() {
        setAnswer(scanner.next());
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
        GeneratorRandomGameBrain generatorRandomGameBrain = new GeneratorRandomGameBrain();

        for (var i = 0; i < generatedNumbers.length; i++) {
            generatedNumbers[i] = generatorRandomGameBrain.createNumber(MAX_NUMBER_RANDOM);
        }
    }

    public final int getGeneratedNumber(int positionNumber) {
        return generatedNumbers[positionNumber];
    }

    public final void greetUser() {
        Scanner scannerGame = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        this.userName = scannerGame.next();
        System.out.println("Hello, " + userName + "!");
    }
}
