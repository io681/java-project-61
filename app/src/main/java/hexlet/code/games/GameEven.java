package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomNumber;

public  class GameEven extends Engine {
    public GameEven(String userName) {
        super(userName);
    }

    public  void startGame() {
        var roundCorrect = 0;

        while (roundCorrect < MAX_COUNT_ROUND){
            createQuestion();
            readAnswer();

            if (checkAnswer(getAnswer(), getRandomGeneratedNumber())) {
                System.out.println("Correct!");
                roundCorrect += 1;
            } else if (getAnswer().equals("yes")) {
                System.out.println("'yes' is wrong answer ;(. Correct answer was '" + "no" + "'");
                System.out.println("Let's try again, " + getUserName() + "!");
                break;
            } else if (getAnswer().equals("no")) {
                System.out.println("'no' is wrong answer ;(. Correct answer was '" + "yes" + "'");
                System.out.println("Let's try again, " + getUserName() + "!");
            } else {
                System.out.println(getAnswer() + " is wrong answer ;(.");
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
    public  boolean checkAnswer(String answer, int number) {
        if (!answer.equals("yes") && !answer.equals("no")) {
            return false;
        }
        return ((answer.equals("yes") && number % 2 == 0) || (answer.equals("no") && number % 2 == 1));
    }
}
