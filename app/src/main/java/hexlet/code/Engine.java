package hexlet.code;

import hexlet.code.utils.GeneratorRandomNumber;

import java.util.Scanner;

public class Engine {

    private  String answer;
    private  int randomGeneratedNumber;
    private final Scanner scanner;
    private final String userName;

    protected static final  int MAX_COUNT_ROUND = 3;
    protected static final  int MAX_NUMBER_RANDOM = 101;

    protected Engine(String userName) {
        this.scanner = new Scanner(System.in);
        this.userName = userName;
    }

    public  void startGame() {
        var roundCorrect = 0;

        while (roundCorrect < MAX_COUNT_ROUND){
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

    public  void createQuestion() {
        GeneratorRandomNumber generatorRandomNumber = new GeneratorRandomNumber();
        setRandomGeneratedNumber(generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM));

        System.out.println("Question: " + getRandomGeneratedNumber());
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

    public int getRandomGeneratedNumber() {
        return randomGeneratedNumber;
    }

    public void setRandomGeneratedNumber(int number) {
        this.randomGeneratedNumber = number;
    }
}
