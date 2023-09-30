package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Scanner;

public class GameCalc extends Engine {

    private  String randomOperation;
    private final String[] operations = {"+", "-", "*"};

    public GameCalc(Scanner scannerBrainGameForSet) {
        super(scannerBrainGameForSet);
    }

    public final void generateDescriptionTask() {
        System.out.println("What is the result of the expression?");
    }

    public final void createQuestion() {
        setRandomOperation(createRandomOperationForQuestion());

        System.out.println("Question: " + getGeneratedNumber(0) + " " + getRandomOperation()
                + " " + getGeneratedNumber(1));
    }

    public final  boolean checkAnswer() {
        return (Integer.parseInt(getAnswer()) == resultOperation(getRandomOperation(), getGeneratedNumber(0),
                getGeneratedNumber(1)));
    }

    public final int resultOperation(String operation, int numberOne, int numberTwo) {
        return switch (operation) {
            case "+" -> numberOne + numberTwo;
            case "-" -> numberOne - numberTwo;
            case "*" -> numberOne * numberTwo;
            default -> throw new RuntimeException("Operator " + operation + " not supported");
        };
    }

    public final String createRandomOperationForQuestion() {
        Utils utils = new Utils();

        int generatedNumber = utils.createNumberInRange(MIN_NUMBER_RANDOM,MAX_NUMBER_RANDOM);
        int numberChoiceForOperation = generatedNumber % operations.length;

        return switch (numberChoiceForOperation) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> null;
        };
    }

    public final String getRandomOperation() {
        return randomOperation;
    }

    public final void setRandomOperation(String randomOperationForSet) {
        this.randomOperation = randomOperationForSet;
    }


}
