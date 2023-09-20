package hexlet.code;

import java.util.Scanner;
import hexlet.code.utils.GeneratorRandomNumber;

public  class GameEven {
    private  int randomNumber;

    private  String answer;
    private final Scanner scanner;

    private final String userName;

    GameEven(String userName) {
        this.scanner = new Scanner(System.in);
        this.userName = userName;
    }

    public  void startGame() {
        var count = 0;

        while (count < 3){
            createQuestion();
            readAnswer();

            if (checkAnswer(getAnswer(), getRandomNumber())) {
                System.out.println("Correct!");
                count += 1;
            } else if (getAnswer().equals("yes")) {
                System.out.println(" 'yes' is wrong answer ;(. Correct answer was '" + "no" + "'");
                System.out.println("Let's try again, " + getUserName() + "!");
                break;
            } else if (getAnswer().equals("no")) {
                System.out.println(" 'no' is wrong answer ;(. Correct answer was '" + "yes" + "'");
                System.out.println("Let's try again, " + getUserName() + "!");
            } else {
                System.out.println(getAnswer() + " is wrong answer ;(.");
                System.out.println("Let's try again, " + getUserName() + "!");
                break;
            }
        }
        if (count == 3) {
            System.out.println("Congratulations, " + getUserName() + "!");
        }
    }

    public  void createQuestion() {
        GeneratorRandomNumber generatorRandomNumber = new GeneratorRandomNumber();
        setRandomNumber(generatorRandomNumber.createNumber());
        System.out.println("Question: " + getRandomNumber());
    }
    public  void readAnswer() {
        setAnswer(scanner.next());
    }
    public  boolean checkAnswer(String answer, int number) {
        if (!answer.equals("yes") && !answer.equals("no")) {
            return false;
        }
        return ((answer.equals("yes") && number % 2 == 0) || (answer.equals("no") && number % 2 == 1));
    }
    public  int getRandomNumber() {
        return randomNumber;
    }
    public  void setRandomNumber(int number) {
        this.randomNumber = number;
    }

    public  String getAnswer() {
        return answer;
    }

    public  void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getUserName() {
        return userName;
    }
}
