package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.GeneratorRandomOperation;

public class GameCalc extends Engine {

    private  String randomOperation;

    public GameCalc(String userName) {
        super(userName);
    }

    public  void createQuestion() {
        GeneratorRandomOperation generatorRandomOperation = new GeneratorRandomOperation();

        setRandomOperation(generatorRandomOperation.createRandomOperation());

        System.out.println("Question: " + getGeneratedNumber(0) + " " + getRandomOperation()
                + " " + getGeneratedNumber(1));
    }

    public  boolean checkAnswer() {
        return (getAnswer().equals(resultOperation(getRandomOperation(), getGeneratedNumber(0),
                getGeneratedNumber(1))));
    }

    public String resultOperation(String operation, int numberOne, int numberTwo) {
        return switch (operation) {
            case "+" -> Integer.toString(numberOne + numberTwo);
            case "-" -> Integer.toString(numberOne - numberTwo);
            case "*" -> Integer.toString(numberOne * numberTwo);
            default -> "not correct data";
        };
    }
    public String getRandomOperation() {
        return randomOperation;
    }

    public void setRandomOperation(String randomOperation) {
        this.randomOperation = randomOperation;
    }


}
