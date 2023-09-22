package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomNumber;
import hexlet.code.utils.GeneratorRandomOperation;

public class GameCalc extends Engine {



    private final int MAX_NUMBER_RANDOM = 101;
    private  int randomNumberOne;
    private  int randomNumberTwo;
    private  String randomOperation;

    public GameCalc(String userName) {
        super(userName);
    }


    public void startGame() {
        var roundCorrect = 0;

        while (roundCorrect < MAX_COUNT_ROUND) {
            createQuestion();
            readAnswer();

            if (checkAnswer(getAnswer(), getRandomOperation(),getRandomNumberOne(),getRandomNumberTwo())) {
                System.out.println("Correct!");
                roundCorrect += 1;
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
        GeneratorRandomOperation generatorRandomOperation = new GeneratorRandomOperation();

        setRandomNumberOne(generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM));
        setRandomNumberTwo(generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM));
        setRandomOperation(generatorRandomOperation.createRandomOperation());

        System.out.println("Question: " + getRandomNumberOne() + " " + getRandomOperation()
                + " " + getRandomNumberTwo());
    }

    public  boolean checkAnswer(String answer, String operation, int numberOne, int numberTwo) {
        return (answer.equals(resultOperation(operation,numberOne,numberTwo)));
    }

    public String resultOperation(String operation, int numberOne, int numberTwo) {
        return switch (operation) {
            case "+" -> Integer.toString(numberOne + numberTwo);
            case "-" -> Integer.toString(numberOne - numberTwo);
            case "*" -> Integer.toString(numberOne * numberTwo);
            default -> "not correct data";
        };
    }
    public String getRandomOperation() {
        return randomOperation;
    }

    public void setRandomOperation(String randomOperation) {
        this.randomOperation = randomOperation;
    }

    public int getRandomNumberOne() {
        return randomNumberOne;
    }

    public void setRandomNumberOne(int randomNumberOne) {
        this.randomNumberOne = randomNumberOne;
    }

    public int getRandomNumberTwo() {
        return randomNumberTwo;
    }

    public void setRandomNumberTwo(int randomNumberTwo) {
        this.randomNumberTwo = randomNumberTwo;
    }

}
