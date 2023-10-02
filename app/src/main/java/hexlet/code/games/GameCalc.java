package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Arrays;
import java.util.Scanner;

public class GameCalc extends Engine {
    private  String randomOperation;
    private final String[] operations = {"+", "-", "*"};
    int[] resultCalc = new int[MAX_COUNT_ROUND];

    public GameCalc(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
    }

    public final void generateDescriptionTask() {
        System.out.println("What is the result of the expression?");
    }

    public final  boolean checkAnswer(int numberAnswer) {
        return (Integer.parseInt(getAnswer()) == getResultCalc(numberAnswer));
    }

    public final void generateDataForQuestions() {
        Utils generatorNumbersUtil = new Utils();
        String[] dataForQuestionsGameCalc = new String[MAX_COUNT_ROUND];

        for (var i = 0; i <  dataForQuestionsGameCalc.length; i++) {
            int numberOne = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            int numberTwo = generatorNumbersUtil.createNumberInRange(MIN_NUMBER_RANDOM, MAX_NUMBER_RANDOM);
            String operator = createRandomOperatorForQuestion();

            setResultCalc(i, resultOperation(operator, numberOne, numberTwo));
            dataForQuestionsGameCalc[i] = numberOne + " " + operator + " " + numberTwo;
        }

        this.dataForQuestions = Arrays.copyOf(dataForQuestionsGameCalc, dataForQuestionsGameCalc.length);
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

    public final int getResultCalc(int indexResultCalc) {
        return this.resultCalc[indexResultCalc];
    }

    public final void setResultCalc(int indexResultCalc, int valueResultCalc) {
        this.resultCalc[indexResultCalc] = valueResultCalc;
    }
}
