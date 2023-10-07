package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;

public class GameGCD extends Games {
    public GameGCD() {
        super();
    }
    public final void generateDataForGame() {
        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            int numberTwo = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);

            String question = numberOne + " " + numberTwo;
            String  correctResult = Integer.toString(resultOperationGDK(numberOne, numberTwo));

            setDataForGameByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
        }
    }

    public final int resultOperationGDK(int numberOne, int numberTwo) {
        var numberGDK = 1;

        for (var i = 1; i <= numberOne; i++) {
            if (numberOne % i == 0 && numberTwo % i == 0) {
                numberGDK = i;
            }
        }

        return numberGDK;
    }

    public final String getRuleGame() {
        return "Find the greatest common divisor of given numbers.";
    }
}

