package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

public class GameCalc extends Engine {
    private final String[] operations = {"+", "-", "*"};
    private final int[] resultCalc;

    public GameCalc(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
        this.resultCalc = new int[MAX_COUNT_ROUND];
    }

    public final void generateDescriptionTask() {
        System.out.println("What is the result of the expression?");
    }

    public final  boolean checkAnswer(int numberAnswer) {
        return (Integer.parseInt(getAnswer()) == getResultCalc()[numberAnswer]);
    }

    public final void generateDataForQuestions() {
        Utils generatorNumbersUtil = new Utils();

        for (var i = 0; i < MAX_COUNT_ROUND; i++) {
            int numberOne = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            int numberTwo = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            String operator = createRandomOperatorForQuestion();

            setResultCalc(i, resultOperation(operator, numberOne, numberTwo));
            setDataForQuestionsByNumber(i, numberOne + " " + operator + " " + numberTwo);
        }
    }

    public final int resultOperation(String operation, int numberOneForResult, int numberTwoForResult) {
        return switch (operation) {
            case "+" -> numberOneForResult + numberTwoForResult;
            case "-" -> numberOneForResult - numberTwoForResult;
            case "*" -> numberOneForResult * numberTwoForResult;
            default -> throw new RuntimeException("Operator " + operation + " not supported");
        };
    }

    public final String createRandomOperatorForQuestion() {
        Utils utils = new Utils();

        int generatedNumber = utils.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
        int numberChoiceForOperation = generatedNumber % operations.length;

        return switch (numberChoiceForOperation) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> null;
        };
    }

    public final int[] getResultCalc() {
        return this.resultCalc;
    }

    public final void setResultCalc(int indexResultCalc, int valueResultCalc) {
        this.resultCalc[indexResultCalc] = valueResultCalc;
    }
}
