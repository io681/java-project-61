package hexlet.code;

import java.util.Scanner;

public abstract class Engine {
    private  String answer;
    private final Scanner scannerBrainGame;
    private String userName;

    private final String[] dataForQuestions;

    public static final int MIN_NUMBER_RANDOM = 1;
    public static final int MAX_NUMBER_RANDOM = 101;

    protected static final  int MAX_COUNT_ROUND = 3;

    protected Engine(Scanner scannerBrainGameForSet) {
        this.scannerBrainGame = scannerBrainGameForSet;
        this.dataForQuestions = new String[MAX_COUNT_ROUND];
    }

    public final void startGame() {
        var roundCorrect = 0;

        greetUser();
        generateDescriptionTask();
        generateDataForQuestions();

        while (roundCorrect < MAX_COUNT_ROUND) {
            createQuestion(getDataForQuestion()[roundCorrect]);
            readAnswer();
            generateTextResultRound(checkAnswer(roundCorrect), roundCorrect);

            if (checkAnswer(roundCorrect)) {
                roundCorrect += 1;
            } else {
                break;
            }
        }

        if (roundCorrect == MAX_COUNT_ROUND) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }

    public final void createQuestion(String currentDataForQuestion) {
        System.out.println("Question: " + currentDataForQuestion);
    }

    public abstract void generateDataForQuestions();

    public abstract boolean checkAnswer(int currentRound);

    public abstract void generateDescriptionTask();

    public final void generateTextResultRound(boolean isCorrect, int currentRound) {
        if (isCorrect) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(."
                    + generateHelperStringForYesNo(currentRound));
            System.out.println("Let's try again, " + getUserName() + "!");
        }
    }

    public final String generateHelperStringForYesNo(int currentRound) {
        if (!checkAnswer(currentRound) && getAnswer().equals("yes")) {
            return "Correct answer was '" + "no" + "'";
        } else if (!checkAnswer(currentRound) && getAnswer().equals("no")) {
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

    public final String[] getDataForQuestion() {
        return this.dataForQuestions;
    }

    public final void setDataForQuestionsByNumber(int numberQuestion, String valueQuestion) {
        this.dataForQuestions[numberQuestion] = valueQuestion;
    }

    public final void greetUser() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        this.userName = scannerBrainGame.next();
        System.out.println("Hello, " + userName + "!");
    }
}
