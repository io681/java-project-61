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
        return (getAnswer().equals(resultOperation(getRandomOperation(), getGeneratedNumber(0),
                getGeneratedNumber(1))));
    }

    public final String resultOperation(String operation, int numberOne, int numberTwo) {
        return switch (operation) {
            case "+" -> Integer.toString(numberOne + numberTwo);
            case "-" -> Integer.toString(numberOne - numberTwo);
            case "*" -> Integer.toString(numberOne * numberTwo);
            default -> "not correct data";
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
