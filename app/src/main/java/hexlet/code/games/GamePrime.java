package hexlet.code.games;

import hexlet.code.Utils;


import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;

public class GamePrime extends Games {
    public GamePrime() {
        super();
    }

    public final void generateDataForGame() {
        Utils generatorNumbersUtil = new Utils();

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);

            String question = Integer.toString(numberOne);
            String  correctResult = "";

            if (isPrime(numberOne)) {
                correctResult += "yes";
            } else {
                correctResult += "no";
            }

            setDataForGameByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
        }
    }

    public final  String[] generateArrayOfPrime() {
        String numbersPrime = "";
        int countOperation = 0;

        for (int i = 1; i <= MAX_NUMBER_RANDOM; i++) {
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

    public final boolean isPrime(int numberCheckPrime) {
        String[] arrayCheckPrime = generateArrayOfPrime();

        for (String element: arrayCheckPrime) {
            if (element.equals(Integer.toString(numberCheckPrime))) {
                return true;
            }
        }

        return false;
    }
    public final String getRuleGame() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
}
