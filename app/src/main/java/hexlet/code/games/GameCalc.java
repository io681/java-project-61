package hexlet.code.games;

import hexlet.code.Utils;

import static hexlet.code.Engine.MAX_COUNT_ROUND;
import static hexlet.code.Engine.MIN_NUMBER_RANDOM;
import static hexlet.code.Engine.MAX_NUMBER_RANDOM;
import static hexlet.code.Engine.POSITION_QUESTION_ONE;
import static hexlet.code.Engine.POSITION_CORRECT_RESULT_ONE;


public class GameCalc extends  Games {
    private final String[] operations = {"+", "-", "*"};

    public GameCalc() {
        super();
    }

    public final void generateDataForGame() {

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            int numberTwo = Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            String operator = createRandomOperator();

            String question = numberOne + " " + operator + " " + numberTwo;
            String  correctResult = Integer.toString(calculateOperation(operator, numberOne, numberTwo));

            setDataForGameByIndex(i, POSITION_QUESTION_ONE, question);
            setDataForGameByIndex(i, POSITION_CORRECT_RESULT_ONE, correctResult);
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
        return operations[Utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM) % operations.length];

    }
    public final String getRuleGame() {
        return "What is the result of the expression?";
    }
}
