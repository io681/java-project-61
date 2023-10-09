package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;

public class GamePrime extends Games {
    public final String[][] generateDataForGame() {
        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);

            String question = Integer.toString(numberOne);
            String correctResult = isPrime(numberOne) ? "yes" : "no";

            setDataForGameByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
        }

        return getDataForGame();
    }

    public final boolean isPrime(int numberCheckPrime) {
        if (numberCheckPrime < 2) {
            return false;
        }

        for (int i = 2; i <= numberCheckPrime / 2; i++) {
            if (numberCheckPrime % i == 0) {
                return false;
            }
        }
        return true;
    }
    public final String getRuleGame() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }
}
