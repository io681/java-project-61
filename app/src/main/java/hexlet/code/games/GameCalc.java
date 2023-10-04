package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.STRUCTURE_ROUND;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;


public class GameCalc {
    private final String[] operations = {"+", "-", "*"};

    private final String[][] dataForGameCalc;

    public GameCalc() {
        this.dataForGameCalc = new String[MAX_COUNT_ROUND][STRUCTURE_ROUND.length];
    }

    public final void generateDataForGameCalc() {
        Utils generatorNumbersUtil = new Utils();

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            int numberTwo = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            String operator = createRandomOperator();

            String question = numberOne + " " + operator + " " + numberTwo;
            String  correctResult = Integer.toString(calculateOperation(operator, numberOne, numberTwo));

            setDataForGameCalcByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameCalcByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
        }
    }

    public final int calculateOperation(String operation, int numberOneForResult, int numberTwoForResult) {
        return switch (operation) {
            case "+" -> numberOneForResult + numberTwoForResult;
            case "-" -> numberOneForResult - numberTwoForResult;
            case "*" -> numberOneForResult * numberTwoForResult;
            default -> throw new RuntimeException("Operator " + operation + " not supported");
        };
    }

    public final String createRandomOperator() {
        Utils utils = new Utils();

        return operations[utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM) % operations.length];

    }

    public final String[][] getDataForGameCalc() {
        return dataForGameCalc;
    }

    public final void setDataForGameCalcByIndex(int indexOne, int indexTwo, String value) {
        this.dataForGameCalc[indexOne][indexTwo] = value;
    }
}
