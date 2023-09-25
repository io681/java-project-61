package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomNumber;

public class GameGCD extends Engine  {

    private  int randomGeneratedNumberSecond;

    public GameGCD(String userName) {
        super(userName);
    }

    public void startGame() {
        var roundCorrect = 0;

        while (roundCorrect < MAX_COUNT_ROUND) {
            createQuestion();
            readAnswer();

            if (checkAnswer(getAnswer(),getRandomGeneratedNumber(),getRandomGeneratedNumberSecond())) {
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

        setRandomGeneratedNumber(generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM));
        setRandomGeneratedNumberSecond(generatorRandomNumber.createNumber(MAX_NUMBER_RANDOM));

        System.out.println("Question: " + getRandomGeneratedNumber() + " " + getRandomGeneratedNumberSecond());
    }

    public  boolean checkAnswer(String answer, int numberOne, int numberTwo) {
        return (answer.equals(resultOperationGDK(numberOne,numberTwo)));
    }

    public String resultOperationGDK(int numberOne, int numberTwo) {
        var numberGDK = 1;

        for (var i = 1; i < numberOne; i ++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                numberGDK = i;
            }
        }

        return Integer.toString(numberGDK);

    }

    public int getRandomGeneratedNumberSecond() {
        return randomGeneratedNumberSecond;
    }

    public void setRandomGeneratedNumberSecond(int randomGeneratedNumberSecond) {
        this.randomGeneratedNumberSecond = randomGeneratedNumberSecond;
    }
}

