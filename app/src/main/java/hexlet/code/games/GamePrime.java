package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomNumber;

public class GamePrime extends Engine {
    public GamePrime(String userName) {
        super(userName);
    }

    public void startGame() {
        var roundCorrect = 0;

        while (roundCorrect < MAX_COUNT_ROUND) {
            createQuestion();
            readAnswer();

            if (checkAnswer(getAnswer())) {
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
//        System.out.println(Arrays.toString(generateArrayOfPrime()));
        System.out.println("Question: " + getRandomGeneratedNumber());
    }

    public  boolean checkAnswer(String answer) {
        if (!answer.equals("yes") && !answer.equals("no")) {
            return false;
        }

        boolean result = checkContainInArray(generateArrayOfPrime(), Integer.toString(getRandomGeneratedNumber()));

        return ((answer.equals("yes") && result) || (answer.equals("no") && !result));
    }
    public  String[] generateArrayOfPrime() {
        String numbersPrime = "";
        int countOperation = 0;

            for (int i = 1; i <MAX_NUMBER_RANDOM; i++) {
                for (int j = 2; j <= i; j++) {
                    if (i % j == 0) {
                        countOperation += 1;
                    }
                }
                if (countOperation == 1) {
                    numbersPrime += i + " ";
                }
                countOperation = 0;
            }

        return numbersPrime.split(" ");
    }

    public boolean checkContainInArray(String[] arrayCheck, String elementCheck) {
        for (String element: arrayCheck) {
            if ( element.equals(elementCheck)) {
                return true;
            }
        }
        return false;
    }
}
