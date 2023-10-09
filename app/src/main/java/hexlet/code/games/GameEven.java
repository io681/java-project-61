package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;


public  class GameEven  extends Games {
    public final String[][] generateDataForGame() {
        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);

            String question = Integer.toString(numberOne);
            String correctResult = isEven(numberOne) ? "yes" : "no";

            setDataForGameByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
        }

        return getDataForGame();
    }

    public final boolean isEven(int checkNumberForIsEven) {
        return checkNumberForIsEven % 2 == 0;
    }

    public final String getRuleGame() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }
}
