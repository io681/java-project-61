package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.STRUCTURE_ROUND;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;

public class GameGCD {
    private final String[][] dataForGameGDK;

    public GameGCD() {
        this.dataForGameGDK = new String[MAX_COUNT_ROUND][STRUCTURE_ROUND.length];
    }
    public final void generateDataForGameGDK() {
        Utils generatorNumbersUtil = new Utils();

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            int numberTwo = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);

            String question = numberOne + " " + numberTwo;
            String  correctResult = Integer.toString(resultOperationGDK(numberOne, numberTwo));

            setDataForGameGDKByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameGDKByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
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

    public final String[][] getDataForGameGDK() {
        return dataForGameGDK;
    }

    public final void setDataForGameGDKByIndex(int indexOne, int indexTwo, String value) {
        this.dataForGameGDK[indexOne][indexTwo] = value;
    }
}

