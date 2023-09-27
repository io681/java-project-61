package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomOperation;

public class GameCalc extends Engine {

    private  String randomOperation;

    public GameCalc() {
        super();
    }

    public void generateDescriptionTask() {
        System.out.println("What is the result of the expression?");
    }

    public final void createQuestion() {
        GeneratorRandomOperation generatorRandomOperation = new GeneratorRandomOperation();

        setRandomOperation(generatorRandomOperation.createRandomOperation(MAX_NUMBER_RANDOM));

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
    public final String getRandomOperation() {
        return randomOperation;
    }

    public final void setRandomOperation(String randomOperation) {
        this.randomOperation = randomOperation;
    }


}
