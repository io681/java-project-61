package hexlet.code;

import hexlet.code.utils.GeneratorRandomNumber;

import java.util.Scanner;

public class Engine {

    private  String answer;
    private final int[] generatedNumbers;
    private final Scanner scanner;
    private String userName;

    protected static final  int MAX_COUNT_ROUND = 3;
    protected static final  int MAX_NUMBER_RANDOM = 101;

    protected Engine(String userName) {
        this.scanner = new Scanner(System.in);
        this.userName = userName;
        this.generatedNumbers = new int[2];
    }

    public  void startGame() {
        var roundCorrect = 0;

        greetUser();

        while (roundCorrect < MAX_COUNT_ROUND) {
            generateNumbers();
            createQuestion();
            readAnswer();

            if (checkAnswer()) {
                System.out.println("Correct!");
                roundCorrect += 1;
            } else if (getAnswer().equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was '" + "no" + "'");
                System.out.println("Let's try again, " + getUserName() + "!");
                break;
            } else if (getAnswer().equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was '" + "yes" + "'");
                System.out.println("Let's try again, " + getUserName() + "!");
                break;
            } else {
                System.out.println("'" + getAnswer() + "'" + " is wrong answer ;(.");
                System.out.println("Let's try again, " + getUserName() + "!");
                break;
            }
        }
        if (roundCorrect == MAX_COUNT_ROUND) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }
    public void greetUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
    }
    public  void createQuestion() {
        System.out.println("Question: " + getGeneratedNumber(0));
    }

    public boolean checkAnswer() {
        return false;
    }

    public  void readAnswer() {
        setAnswer(scanner.next());
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserName() {
        return userName;
    }

    public void generateNumbers() {
        GeneratorRandomNumber generatorRandomNumber = new GeneratorRandomNumber();

        for (var i = 0; i < generatedNumbers.length; i++) {
            generatedNumbers[i] = generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM);
        }
    }

    public int getGeneratedNumber(int positionNumber) {
        return generatedNumbers[positionNumber];
    }
}
