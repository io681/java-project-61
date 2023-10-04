package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.STRUCTURE_ROUND;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;


public  class GameEven {

    private final String[][] dataForGameEven;

    public GameEven() {
        this.dataForGameEven = new String[MAX_COUNT_ROUND][STRUCTURE_ROUND.length];
    }

    public final void generateDataForGameEven() {
        Utils generatorNumbersUtil = new Utils();

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);

            String question = Integer.toString(numberOne);
            String  correctResult = "";

            if (isEven(numberOne)) {
                correctResult += "yes";
            } else {
                correctResult += "no";
            }

            setDataForGameEvenByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameEvenByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
        }
    }

    public final boolean isEven(int checkNumberForIsEven) {
        return checkNumberForIsEven % 2 == 0;
    }

    public String[][] getDataForGameEven() {
        return dataForGameEven;
    }

    public void setDataForGameEvenByIndex(int indexOne, int indexTwo, String value) {
        this.dataForGameEven[indexOne][indexTwo] = value;
    }
}
